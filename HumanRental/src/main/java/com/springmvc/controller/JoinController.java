package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.domain.Member;
import com.springmvc.service.MemberService;

@Controller
@RequestMapping
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
		return "redirect:/login";
	}
	
	@GetMapping(value = "/join/DupCheck", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String idCheck(@RequestParam("targetData") String targetData,
						  @RequestParam("targetLabel") String targetLabel) {
		
		if(targetLabel.equals("아이디")) {
			if(memberService.idCheck(targetData)) {
				return "true";
			} else {
				return "false";
			}
		}
		
		if(targetLabel.equals("닉네임")) {
			if(memberService.nickCheck(targetData)) {
				return "true";
			} else {
				return "false";
			}
		}
		
		return "false";
		
	}
}
