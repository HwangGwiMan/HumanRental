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
import com.springmvc.domain.Mentee;
import com.springmvc.service.MenteeService;
import com.springmvc.domain.Member;

@Controller
public class MenteeController {
	
	@Autowired
	MenteeService MenteeService;
		
	@GetMapping("/mentee")
	public String Menteeread(@RequestParam("mode") String mode,Model model, HttpServletRequest request) {
		System.out.println("Menteeroad함수로는 오니?");
		HttpSession session = request.getSession();
		String memberId	= (String)session.getAttribute("user");
		System.out.println(memberId);
		System.out.println("memberId가위에 뜰꺼임 떠야됨 뜰거임 무조건 ");
		int a = MenteeService.getMentee(memberId);
			  
		System.out.println(a);
		if(a==0) {
			model.addAttribute("mode",mode);
			
		}else{
			mode = "menteeInformation";
			System.out.println("else 구문안인데 여긴 오니?");
		Mentee mentee = MenteeService.getInformation(memberId);
			model.addAttribute("mode",mode);
			model.addAttribute("Mentee",mentee);
		}
		
		return "MyPage";
	}
	
	  @PostMapping("/mentee") 
	  public String MenteeRegister(@ModelAttribute Mentee Mentee, Model model,HttpServletRequest request) {
		  System.out.println("이건 멘티프로필 등록인데 여기는 오니?");
		   MenteeService.registerMentee(Mentee,request);
		  return "redirect:/mentee?mode=menteeProfileRead";
	  }
	  
	 @GetMapping("/mentee2")
	 public String MenteeProfileUpdateform(@RequestParam("mode") String mode,Model model ,HttpServletRequest request) {
		 System.out.println("111111111");
		 HttpSession session = request.getSession();
		String memberId	= (String)session.getAttribute("user");
		 Mentee mentee = MenteeService.getInformation(memberId);
		 System.out.println(mentee.getIntroduction());
		 System.out.println(mentee.getInterest());

		
		 model.addAttribute("mode",mode);
		 model.addAttribute("Mentee",mentee);
		 System.out.println("22222222222222");
		return "MyPage"; 
	 }
	  @PostMapping("/menteeProfileUpdate") 
	  public String MenteeProfileUpdate(@ModelAttribute Mentee Mentee, Model model,HttpServletRequest request) {
		  System.out.println("이건 멘티프로필 등록인데 여기는 오니?");
		   MenteeService.UpdateMentee(Mentee,request);
		  return "redirect:/mentee?mode=menteeProfileRead";
	  }
	  @GetMapping("/mentee3")
	  public String  MenteeProfileDelete(Model model, HttpServletRequest request) {
		  MenteeService.deleteMentee(request);
		  return "redirect:/myInfo?mode=myPage";
	  }
	  
}
