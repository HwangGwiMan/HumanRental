package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.domain.Member;
import com.springmvc.service.MemberService;

@Controller
@RequestMapping("/login")
public class JoinController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/join")
	public String requestJoinPage(@ModelAttribute Member member) {
		return "Join";
	}
	
	@PostMapping("/join")
	public String joinMethod(@ModelAttribute Member member) {
		memberService.join(member);
		return "redirect:/main";
	}
}
