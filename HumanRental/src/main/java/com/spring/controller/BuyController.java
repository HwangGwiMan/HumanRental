package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BuyController {
	

	@GetMapping("/buy")
	public String requestMethod(Model model) {
		return "buy";
	}
}
