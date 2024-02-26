package com.springmvc.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.Reservation;
import com.springmvc.service.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	ReservationService reservationservice;
	
	//멘티게시글 리스트 페이지
	@PostMapping("/reservation/buying")
	public String BuyingReservation(@RequestParam("buyingId") String buyingId, Model model,
			@RequestParam("date") String date, @RequestParam("content") String content, HttpServletRequest request) {
		
//		System.out.println(date);
//		System.out.println(content);
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("user");
		Reservation reservation = reservationservice.BuyingReservationCreate(buyingId, date, content, memberId, model);
		model.addAttribute("reservation", reservation);
		model.addAttribute("mode", "reservation");
		return "CheckPage"; // 추후 예약 현황 페이지로
	}
	

	//멘티게시글 리스트 페이지
	@PostMapping("/reservation/selling")
	public String SellingReservation(@RequestParam("sellingId") String sellingId, Model model,
			@RequestParam("date") String date, @RequestParam("content") String content, HttpServletRequest request) {
		
//		System.out.println(date);
//		System.out.println(content);
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("user");
		Reservation reservation = reservationservice.SellingReservationCreate(sellingId, date, content, memberId, model);
		model.addAttribute("reservation", reservation);
		model.addAttribute("mode", "reservation");
		return "CheckPage"; // 추후 예약 현황 페이지로
	}
	
}
