package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SearchController {
	
		
	@PostMapping("/Search")
	public String test(@RequestParam("search") String search, Model model) {
		
		
		
		

	    return "SearchPage";
	}
}
