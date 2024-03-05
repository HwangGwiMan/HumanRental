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
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.domain.Member;
import com.springmvc.domain.Review;
import com.springmvc.repository.ReservationRepository;
import com.springmvc.domain.Buying;
import com.springmvc.service.MemberService;
import com.springmvc.service.ReservationService;
import com.springmvc.service.ReviewService;
import com.springmvc.service.BuyingService;

@Controller
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	ReservationService reservationService;
	
	@GetMapping("/ReviewWrite")
	public String ReviewWrite(@RequestParam String reservationId, Model model) {
		
		reservationService.GetReservationInfo(reservationId, model);
//		model.addAttribute("reservationId", reservationId);
		model.addAttribute("mode", "ReviewPage");
		model.addAttribute("reviewmode", "write");
		return "MyPage";
	}
	
	@PostMapping("/ReviewWrite")
	public String ReviewWrite(@ModelAttribute Review review, @RequestParam String reservationId, Model model) {
		
		if(review.getBoardId().contains("buy")) {
			reviewService.BuyReviewWrite(review);
			reservationService.ReservationApproval(reservationId, "review");
		}
		else {
			reviewService.SellReviewWrite(review);
			reservationService.ReservationApproval(reservationId, "review");
		}

		return "redirect:/reservationListManagement";
	}
	
	@GetMapping("/ReviewRead")
	public String ReviewRead(@RequestParam String reservationId, Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("user");
		
		try {
			reservationService.GetReservationInfo(reservationId, model);
			reviewService.getReviewByResvId(reservationId, model, memberId);
		}
		catch(Exception e) {
			e.printStackTrace();
			return "false";
		}
		model.addAttribute("mode", "ReviewPage");
		model.addAttribute("reviewmode", "read");
		return "MyPage";
	}
	
	@GetMapping("/ReviewCheck")
	@ResponseBody
	public String ReviewCheck(@RequestParam String reservationId, Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("user");
		
		try {
			reservationService.GetReservationInfo(reservationId, model);
			reviewService.ReviewCheck(reservationId, model, memberId);
		}
		catch(Exception e) {
			e.printStackTrace();
			return "false";
		}
		return "true";
	}
	
	@GetMapping("/ReviewUpdate")
	public String ReviewUpdate(@RequestParam String reservationId, Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("user");
		
		try {
			reservationService.GetReservationInfo(reservationId, model);
			reviewService.getReviewByResvId(reservationId, model, memberId);
		}
		catch(Exception e) {
			e.printStackTrace();
			return "false";
		}
		
		model.addAttribute("mode", "ReviewPage");
		model.addAttribute("reviewmode", "update");
		return "MyPage";
	}
	
	@PostMapping("/ReviewUpdate")
	public String ReviewUpdate(@ModelAttribute Review review, @RequestParam String reservationId, Model model) {
		
		reviewService.ReviewUpdate(review);
		return "redirect:/ReviewRead?reservationId="+reservationId;
	}
	
}
