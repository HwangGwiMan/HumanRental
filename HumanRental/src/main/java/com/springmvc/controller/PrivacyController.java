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
			model.addAttribute("member", member);
			model.addAttribute("mode", mode);
			
			
			if(mode.equals("myPage")) {
				if(member.getProfileImage() == null) {
					model.addAttribute("image", "default.png");
				}
				
			} else if(mode.equals("myPageEdit")) {
				if(member.getProfileImage() == null) {
					model.addAttribute("image", "default.png");
				}
				
			} else if(mode.equals("userCheck")) {
				
			}
			return "MyPage";
		} else {
			return "redirect:/main";
		}
		
		
	}
	
	
	@PostMapping("/myInfo")
	public String postMethodName(@RequestParam("mode") String mode,
								 Member member,
								 Model model) {
		Member targetMember = memberService.Login(member.getMemberId(), member.getMemberPw());
		if((targetMember.getMemberId().equals(member.getMemberId())) && (targetMember.getMemberPw().equals(member.getMemberPw()))) {
			model.addAttribute("mode", mode);
			return "redirect:/myInfo";
		} else {
			return "MyPage"; 
		}
	}
}
