package com.springmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.domain.Black;
import com.springmvc.service.BlackService;

@Controller
public class BlackController {
	
	@Autowired
	BlackService blackService;
	
	@PostMapping("/registBlack")
	@ResponseBody
	public String registBlack(@RequestParam("memberId") String memberId) {
		Black black = new Black();
		black.setMemberId(memberId);
		try {
			blackService.registBlack(black);
			return "RegistrationCompleted";
		} catch (DataIntegrityViolationException e) {
			return "AlreadyRegistered";
		}
	}
}
