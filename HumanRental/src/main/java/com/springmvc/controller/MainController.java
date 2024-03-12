package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springmvc.service.MentorService;
import com.springmvc.service.ReviewService;

@Controller
public class MainController {
	
	@Autowired
	MentorService mentorService;
	
	@Autowired 
	ReviewService reviewService;
	
	// 메인 페이지 호출
	@GetMapping("/main")
	public String requestHome1(Model model, HttpServletRequest request) {
		
		model.addAttribute("mentorlist", mentorService.getBestMentorList());
		model.addAttribute("reviewlist", reviewService.getBestReviewList());
		
		return "Main";
	}

	// 알림 호출
	@GetMapping("/alarm")
	public String requestAlarm(Model model) {
		return "alarm";
	}
	
	// 멘토 신청 페이지 호출
	@GetMapping("/applyToMento")
	public String requestApplyToMento(Model model) {
		return "applymento";
	}
	
	// 팝니다 페이지 호출
	@GetMapping("/buy")
	public String requestBuy(Model model) {
		return "buy";
	}
	
	// 커뮤니티 페이지 호출
	@GetMapping("/communitiy")
	public String requestCommunitiy(Model model) {
		return "community";
	}
	
	// 재능 기부 페이지 호출 
	@GetMapping("/give")
	public String requestGive(Model model) {
		return "TalentGive";
	}
	
	// 마이 페이지 호출
//	@GetMapping("/mypage")
//	public String requestMypage(Model model) {
//		return "mypage";
//	}
	
	// 멘티 구함 페이지 호출
	@GetMapping("/findMentee")
	public String requestSell(Model model) {
		return "sell";
	}
	
	// 멘토 구함 페이지 호출
	@GetMapping("/findMentor")
	public String requestTrade(Model model) {
		return "trade";
	}
}
