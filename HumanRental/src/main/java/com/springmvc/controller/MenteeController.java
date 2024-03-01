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
import com.springmvc.service.MenteeService;
import com.springmvc.domain.Member;
import com.springmvc.domain.Mentee;

@Controller
public class MenteeController {
	
	@Autowired
	MenteeService Menteeservice;
		
	@GetMapping("/mentee")
	public String Menteeread(@RequestParam("mode") String mode,Model model, HttpServletRequest request) {
		System.out.println("Menteeroad함수로는 오니?");
		HttpSession session = request.getSession();
		String memberId	= (String)session.getAttribute("user");
		boolean a =  Menteeservice.getMentee(memberId);
			  System.out.println("a값은 뭐냐"+a);
		System.out.println(a);
		if(a==false) {
			System.out.println("false 값으로 나온다는 증거임 ㅋ");
			mode ="menteeProfileRegister";
			model.addAttribute("mode",mode);
			return "redirect:/myInfo";
			
		}else{
			System.out.println("else 로 오니?");
			mode="menteeInformation";
		Mentee mentee =Menteeservice.getInformation(memberId);
		 model.addAttribute("mode", mode);
		 model.addAttribute("mentee",mentee);
			return "MyPage";
		}
		
	}
	
	  @PostMapping("/menteeregisterinsert") 
	  public String MenteeRegister(@ModelAttribute Mentee mentee, Model model,HttpServletRequest request, @RequestParam("mode")  String mode ) {
		  System.out.println("이건 멘티프로필 등록인데 여기는 오니?");
			HttpSession session = request.getSession();
			String memberId	= (String)session.getAttribute("user");
			Menteeservice.registerMentee(mentee, memberId);
			System.out.println("인설트 구문 들어갔지?");	
			 mode = "mentorProfile";
		     model.addAttribute("mode", mode);
		     
	         return "redirect:/mentee";
		
		  }
	  
//	 @GetMapping("/mentee2")
//	 public String MenteeProfileUpdateform(@RequestParam("mode") String mode,Model model ,HttpServletRequest request) {
//		 System.out.println("111111111");
//		 HttpSession session = request.getSession();
//		String memberId	= (String)session.getAttribute("user");
////		 Mentee mentee = MenteeService.getInformation(memberId);
//		 System.out.println(mentee.getIntroduction());
//		 System.out.println(mentee.getInterest());
//
//		
//		 model.addAttribute("mode",mode);
//		 model.addAttribute("Mentee",mentee);
//		 System.out.println("22222222222222");
//		return "MyPage"; 
//	 }
//	  @PostMapping("/menteeProfileUpdate") 
//	  public String MenteeProfileUpdate(@ModelAttribute Mentee Mentee, Model model,HttpServletRequest request) {
//		  System.out.println("이건 멘티프로필 등록인데 여기는 오니?");
//		   MenteeService.UpdateMentee(Mentee,request);
//		  return "redirect:/mentee?mode=menteeProfileRead";
//	  }
//	  @GetMapping("/mentee3")
//	  public String  MenteeProfileDelete(Model model, HttpServletRequest request) {
//		  MenteeService.deleteMentee(request);
//		  return "redirect:/myInfo?mode=myPage";
//	  }
	  
//	  @GetMapping("/menteeprofileCheck")
//	  @ResponseBody
//	  	public String MenteeCheck(HttpServletRequest request) {
//			HttpSession session = request.getSession();
//			String memberId = (String) session.getAttribute("user");
//			
//			if(memberId == null) {
//				return "notLogin";
//			}
//			
//			int mentee = MenteeService.getMentee(memberId);
//			if(mentee == 0) {
//				return "false";
//			} else {
//				return "true";
//			}
//		}
}
