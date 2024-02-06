package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplyMentoController {
	
	@GetMapping("/applymento")
	public String requestMethod(Model model) {
			return "applymento";
		}
	
}
