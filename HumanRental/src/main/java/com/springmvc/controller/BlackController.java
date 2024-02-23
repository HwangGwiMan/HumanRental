package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlackController {
	
	@PostMapping("/registBlack")
	public String registBlack() {
		
		return "redirect:/myInfo?mode=report";
	}
}
