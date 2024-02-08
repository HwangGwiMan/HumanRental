package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String Login(@RequestParam("memberId") String memberId,
						@RequestParam("memberPw") String memberPw,
						HttpServletRequest request) {
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		System.out.println(member.getMemberId());
		
		if(memberService.Login(member)) {
			HttpSession session = request.getSession();
			session.setAttribute("id", member.getMemberId());
			return "true";
		} else {
			return "false";
		}
	}
}
