package com.springmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.domain.Black;
import com.springmvc.service.BlackService;
import com.springmvc.service.ReportService;

@Controller
public class BlackController {
	
	@Autowired
	BlackService blackService;
	
	@Autowired
	ReportService reportService;
	
	@PostMapping("/registBlack")
	@ResponseBody
	public String registBlack(@RequestParam("memberId") String memberId,
							  @RequestParam("reportId") String reportId) {
		Black black = new Black();
		black.setMemberId(memberId);
		
		reportService.stateUpdate(reportId, "Black");
		
		// TODO
		/* 블랙 리스트 추가시 알람 생성 */
		
		try {
			blackService.registBlack(black);
			return "RegistrationCompleted";
		} catch (DataIntegrityViolationException e) {
			return "AlreadyRegistered";
		}
	}
	
	@GetMapping("/removeBlack")
	public String removeBlack(@RequestParam("id") String blackId) {
		blackService.removeBlack(blackId);
		return "redirect:/myInfo?mode=blackListManagement";
	}
}
