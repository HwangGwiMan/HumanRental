package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springmvc.domain.Member;
import com.springmvc.service.MemberService;

@Controller
public class LoginController {
	
	@Autowired
	MemberService memberService;
	
	// 회원 가입 페이지 호출
	@GetMapping("/login")
	public String requestMemberJoin(@ModelAttribute Member member) {
		return "Login";
	}
	
	@PostMapping("/login")
	public String Login(@ModelAttribute Member member, Model model) {
		if(memberService.Login(member)) {
			return "redirect:/main";
		} else {
			model.addAttribute("error", "아이디 비밀번호 확인 부탁드립니다.");
			return "Login";
		}
	}
}
