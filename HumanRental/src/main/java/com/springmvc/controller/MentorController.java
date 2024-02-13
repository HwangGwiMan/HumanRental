package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MentorController {
	
	@GetMapping("/mentorlist")
	public String MentorList(Model model) {
		return "mentorlist";
	}
	
	@GetMapping("/mentorDetail")
	public String MentorDetail(Model model) {
		return "mentorDetail";
	}
}
