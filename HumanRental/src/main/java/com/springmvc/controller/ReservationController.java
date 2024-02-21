package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.Member;
import com.springmvc.domain.Buying;
import com.springmvc.service.MemberService;
import com.springmvc.service.ReservationService;
import com.springmvc.service.BuyingService;

@Controller
public class ReservationController {

	@Autowired
	ReservationService reservationservice;
	
	//멘티게시글 리스트 페이지
	@GetMapping("/reservation/create")
	public String ReservationCreate(@RequestParam("buyingId") String buyingId, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("user");
		reservationservice.ReservationCreate(buyingId, memberId);
		
		return "SellingList";
	}
}
