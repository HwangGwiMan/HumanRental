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
import com.springmvc.service.AlarmService;
import com.springmvc.service.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	ReservationService reservationservice;
	
	@Autowired
	AlarmService alarmService;
	
	//멘티게시글 리스트 페이지
	@PostMapping("/reservation/buying")
	public String BuyingReservation(@RequestParam("buyingId") String buyingId, Model model,
			@RequestParam("date") String date, @RequestParam("content") String content, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("user");
		Reservation reservation = reservationservice.BuyingReservationCreate(buyingId, date, content, memberId, model);
		model.addAttribute("reservation", reservation);
		model.addAttribute("mode", "reservation");
		
		alarmService.createReservationApplyAlarm(reservation);
		
		return "CheckPage"; // 추후 예약 현황 페이지로
	}
	

	@PostMapping("/reservation/selling")
	public String SellingReservation(@RequestParam("sellingId") String sellingId, Model model,
			@RequestParam("date") String date, @RequestParam("content") String content, HttpServletRequest request) {
		System.out.println("SellingReservation 여기로 오니??");
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("user");
		Reservation reservation = reservationservice.SellingReservationCreate(sellingId, date, content, memberId, model);
		model.addAttribute("reservation", reservation);
		model.addAttribute("mode", "reservation");
		
		alarmService.createReservationApplyAlarm(reservation);
		
		return "CheckPage"; // 추후 예약 현황 페이지로
	}
	
	@GetMapping("/reservationListManagement")
	public String ReservationListManagement(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("user");
		reservationservice.getReservationListById(memberId, model);
		model.addAttribute("mode", "reservationListManagement");
		return "MyPage";
	}
	

	@GetMapping("/reservationApprovalManagement")
	public String ReservationApprovalManagement(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("user");
		reservationservice.getReservationApprovalListById(memberId, model);
		model.addAttribute("mode", "reservationApprovalManagement");
		return "MyPage";
	}
	
	@GetMapping("/reservationApprovalInfo")
	public String ReservationApprovalInfo(@RequestParam String reservationId, Model model) {
		reservationservice.GetReservationInfo(reservationId, model);
		model.addAttribute("mode", "reservationApprovalInfo");
		return "MyPage";
	}

	@GetMapping("/reservationApproval")
	public String ReservationApproval(@RequestParam String reservationId, @RequestParam String approval, Model model) {
		reservationservice.ReservationApproval(reservationId, approval);
		model.addAttribute("mode", "reservationApprovalManagement");
		
		alarmService.createReservationConfirmAlarm(reservationId, approval);
		
		return "redirect:/reservationApprovalManagement";
	}
	
	@GetMapping("/reservationInfo")
	public String ReservationInfo(@RequestParam String reservationId, Model model) {
		reservationservice.GetReservationInfo(reservationId, model);
		model.addAttribute("mode", "reservationInfo");
		return "MyPage";
	}
}
