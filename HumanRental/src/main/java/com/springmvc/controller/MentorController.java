package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.cj.xdevapi.JsonArray;
import com.springmvc.domain.MentorProfile;
import com.springmvc.domain.MentorRegistInfo;
import com.springmvc.service.AlarmService;
import com.springmvc.service.MentorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class MentorController {
	
	@Autowired
	MentorService mentorService; 
	
	@Autowired
	AlarmService alarmService;
	
	@GetMapping("/mentorlist")
	public String MentorList(Model model) {
		return "mentorlist";
	}
	
	@GetMapping("/mentorDetail")
	public String MentorDetail(Model model) {
		return "mentorDetail";
	}
	
	@GetMapping("/mentorIntro")
	public String requestMentorIntroPage() {
		return "MentorIntro";
	}
	
	@GetMapping("/mentorCheck")
	@ResponseBody
	public String MentorCheck(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("user");
		
		if(memberId == null) {
			return "notLogin";
		}
		
		MentorRegistInfo mentorRegistInfo = mentorService.getMentorApplyByMemberId(memberId);

		if(mentorRegistInfo != null) {
			return "AlreadyApply";
		}
		
		MentorProfile mentor = mentorService.getMentor(memberId);
		if(mentor == null) {
			return "true";
		} else {
			return "false";
		}
	}
	
	@GetMapping("/mentorApply")
	public String requestMentorRegistPage(HttpServletRequest request) {
		return "MentorApply";
	}
	
	@PostMapping("/mentorApply/submit")
	public String mentorApplySubmit(MentorRegistInfo mentorRegistInfo,
									 HttpServletRequest request) {
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("user");
		mentorRegistInfo.setMemberId(memberId);
			
		mentorService.mentorApply(mentorRegistInfo);
		
		alarmService.createMentoApplyAlarm(memberId);
		
		return "redirect:/main";
	}	
	
	@GetMapping("/mentorRegist")
	public String mentorRegist(@RequestParam("id") String memberId) {
		System.out.println(memberId);
		mentorService.mentorRegist(memberId);
		return "redirect:/myInfo?mode=mentorApplyManagement";
	}
	
	@GetMapping("/mentorApplyRefuse")
	public String mentorApplyRefuse() {
		return null;
	}
}
