package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.Member;
import com.springmvc.service.MemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
public class PrivacyController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/myInfo")
	public String requestMyPage(@RequestParam("mode") String mode,
								Model model, 
								HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null) {
			String memberId = (String) session.getAttribute("user");
			Member member = memberService.getMember(memberId);
			
			if(member.getProfileImage().equals("")) {
				member.setProfileImage("default.png");
			}
			
			model.addAttribute("member", member);
			model.addAttribute("mode", mode);
			
			if(member.getProfileImage() == null) {
				model.addAttribute("image", "default.png");
			}
			
			return "MyPage";
		} else {
			return "redirect:/main";
		}
		
		
	}
	
	// 2차 로그인 확인
	@PostMapping("/myInfo")
	public String userCheck(HttpServletRequest request, 
							Member member,
							Model model) {
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("user");
		Member sessionMember = memberService.getMember(memberId);
		
		if(sessionMember != null) {
			if((sessionMember.getMemberId().equals(member.getMemberId())) && (sessionMember.getMemberPw().equals(member.getMemberPw()))) {
				model.addAttribute("mode", "myPageEdit");
				return "redirect:/myInfo";
			} else {
				model.addAttribute("mode", "myPage");
				return "redirect:/myInfo"; 
			}
		} else {
			model.addAttribute("mode", "myPage");
			return "redirect:/myInfo"; 
		}
	}
	
	// 회원 정보 수정
	@PostMapping("/myPageEdit")
	public String myPageEdit(HttpServletRequest request,
							 Member member, 
							 Model model) {
		if(member.getProfileImage().equals(" ")) {
			member.setProfileImage("default.png");
		}
		
		System.out.println(member.getProfileImage());
		
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("user");
		
		memberService.updateMember(member, memberId);
		
		session.setAttribute("user", member.getMemberId());
		
		model.addAttribute("mode", "myPage");
		return "redirect:/myInfo";
	}
}
