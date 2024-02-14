package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenteeController {
	
	@GetMapping("/menteelist")
	public String MentorList(Model model) {
		return "menteelist";
	}
	
	@GetMapping("/menteeDetail")
	public String MenteeDetail(Model model) {
		return "menteeDetail";
	}
}
