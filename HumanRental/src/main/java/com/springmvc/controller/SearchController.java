package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {
	
	//페이지 테스트용
	@GetMapping("/SearchPage")
	public String test(Model model) {
		return "SearchPage";
	}
}
