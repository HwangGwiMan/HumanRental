package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.domain.Mentor;
import com.springmvc.service.MemberService;
import com.springmvc.service.MenteeService;
import com.springmvc.domain.Member;
import com.springmvc.domain.Mentee;


@Controller
public class MenteeController {
	
	@Autowired
	MenteeService Menteeservice;
	
	@Autowired	
	MemberService memberservice;
	
	@GetMapping("/mentee")
	public String Menteeread(@RequestParam("mode") String mode,Model model, HttpServletRequest request) {
		System.out.println("Menteeroad함수로는 오니?");
		HttpSession session = request.getSession();
		String memberId	= (String)session.getAttribute("user");
		boolean a =  Menteeservice.getMentee(memberId);
			  System.out.println("a값="+a);
		System.out.println(a);
		if(a==false) {
			mode ="menteeProfileRegister";
			model.addAttribute("mode",mode);
			return "redirect:/myInfo";
			
		}else{
			mode="menteeInformation";
			Mentee mentee =Menteeservice.getInformation(memberId);
			Member member  =memberservice.getMember(memberId);
			System.out.println(mentee.getMenteeprofileaddress());
			model.addAttribute("mode", mode);
			model.addAttribute("mentee",mentee);
			model.addAttribute("member",member);
			return "MyPage";
		}
		
	}
	
	  @PostMapping("/menteeregisterinsert") 
	  public String MenteeRegister(@ModelAttribute Mentee mentee, Model model,HttpServletRequest request, @RequestParam("mode")  String mode ) {
		  	System.out.println("이건 멘티프로필 등록인데 여기는 오니?");
			HttpSession session = request.getSession();
			String memberId	= (String)session.getAttribute("user");
			Menteeservice.registerMentee(mentee, memberId);
			 mode = "mentorProfile";
		     model.addAttribute("mode", mode);
		     
	         return "redirect:/mentee";
		
		  }
	  
	 @GetMapping("/callmenteeupdateform")
	 public  String MenteeProfileUpdateform(@RequestParam("mode") String mode,Model model ,HttpServletRequest request) {
		 HttpSession session = request.getSession();
		 String memberId	= (String)session.getAttribute("user");
		 Mentee mentee = Menteeservice.getInformation(memberId);
		 Member	member = memberservice.getMember(memberId);
		 mode ="menteeProfileUpdate";
		 
		 model.addAttribute("mode",mode);
		 model.addAttribute("Mentee",mentee);
		 model.addAttribute("member",member);
		return "MyPage"; 
	 }
	  @PostMapping("/menteeProfileUpdate") 
	  public String MenteeProfileUpdate(@ModelAttribute Mentee Mentee, Model model,HttpServletRequest request,String mode) {
		  HttpSession session = request.getSession();
		  String memberId	= (String)session.getAttribute("user");
		  Menteeservice.UpdateMentee(Mentee,memberId);
		  
		  mode = "menteeInformation";
		  model.addAttribute("mode",mode);
		  
		  return "MyPage"; 
	  }

	  
	  @GetMapping("/menteeprofileCheck")
	  @ResponseBody
	  	public String MenteeCheck(HttpServletRequest request) {
			HttpSession session = request.getSession();
			String memberId = (String) session.getAttribute("user");
			
			if(memberId == null) {
				return "notLogin";
			}
			
			boolean mentee = Menteeservice.getMentee(memberId);
			if(mentee ==false) {
				return "false";
			} else {
				return "true";
			}
		}
}
