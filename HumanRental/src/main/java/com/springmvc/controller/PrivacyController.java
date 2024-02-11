package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springmvc.domain.Member;
import com.springmvc.service.MemberService;



@Controller
public class PrivacyController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/mypage")
	public String requestMyPage(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null) {
			String memberId = (String) session.getAttribute("user");
			Member member = memberService.getMember(memberId);
			model.addAttribute("member", member);
		}
		
		return "MyPage";
	}
}
