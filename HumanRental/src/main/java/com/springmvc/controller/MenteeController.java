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
	
	
	@PostMapping("menteeprofile")
	public String Menteeprofile( @ModelAttribute Mentee Mentee ,HttpServletRequest request) {
		System.out.println("멘티프로필등록 까지 올수있니..?");
		/*
		 * HttpSession session= request.getSession();
		 * session.setAttribute("user",Mentee.getMenteeId());
		 */
		MenteeService.registerMentee(Mentee);
		return "redirect:main";
	}
	
	@PostMapping("menteeProfileRead")
	public String Menteeread(@RequestParam("mode") String mode,Model model, HttpServletRequest request) {
		System.out.println("맨티 프로필 조회까지 올수 있니?");
		HttpSession session= request.getSession();	
		System.out.println("그럼 여기는 올수 있냐?");
		String MenteeId = (String)session.getAttribute("user");
		
		Mentee Mentee = MenteeService.getMentee(MenteeId); 
		model.addAttribute("Mentee",Mentee);
		System.out.println(Mentee);
		return "redirect:mypage";
	}
	
	@GetMapping("/menteeupdate")
	public String MenteeDet(Model model) {
		return "redirect:main";
	}
	@GetMapping("/menteedelte")
	public String MenteeDetail(Model model) {
		return "redirect:main";
	}
}
