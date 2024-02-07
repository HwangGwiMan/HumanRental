package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.domain.Member;

@Controller
public class MainController {
	
	// 메인 페이지 호출
	@GetMapping("/main")
	public String requestHome() {
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
	@GetMapping("/mypage")
	public String requestMypage(Model model) {
		return "mypage";
	}
	
	// 멘티 구함 페이지 호출
	@GetMapping("/findMenti")
	public String requestSell(Model model) {
		return "sell";
	}
	
	// 멘토 구함 페이지 호출
	@GetMapping("/findMento")
	public String requestTrade(Model model) {
		return "trade";
	}
}
