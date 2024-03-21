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

import com.springmvc.domain.Reservation;
import com.springmvc.domain.Review;
import com.springmvc.service.ReservationService;
import com.springmvc.service.ReviewService;

@Controller
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	ReservationService reservationService;
	
	@GetMapping("/ReviewWrite")
	public String ReviewWrite(@RequestParam String reservationId, Model model) {
		
		reservationService.GetReservationInfo(reservationId, model);
		model.addAttribute("mode", "ReviewPage");
		model.addAttribute("reviewmode", "write");
		return "MyPage";
	}
	
	@PostMapping("/ReviewWrite")
	public String ReviewWrite(@ModelAttribute Review review, @RequestParam String reservationId, Model model, HttpServletRequest request) {
		
		Reservation reservation = reservationService.GetReservationInfo(reservationId, model);
		String memberId = reservation.getMemberId();
		String applicantMemberId = reservation.getApplicantMemberId();
		review.setReservationId(reservationId);
		
//		System.out.println("포스트 리뷰");
//		System.out.println("memberId"+memberId);
//		System.out.println("review.getMemberId()"+review.getMemberId());
//		System.out.println("테스트"+memberId==review.getMemberId());
		
		if(memberId.equals(review.getMemberId())) {
				reviewService.MemberReviewWrite(review);
				reviewService.StarRateUpdate2(applicantMemberId, review, false);
		}
		else {
			if(review.getBoardId().contains("buy")) {
				reviewService.BuyReviewWrite(review);
				reviewService.StarRateUpdate(memberId, review, false);
			}
			else {
				reviewService.SellReviewWrite(review);
				reviewService.StarRateUpdate(memberId, review, false);
			}
		}
		
		return "redirect:/reservationListManagement";
	}
	
	@GetMapping("/ReviewRead")
	public String ReviewRead(@RequestParam String reservationId, Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("user");
		
		reservationService.GetReservationInfo(reservationId, model);
		reviewService.getReviewByResvId(reservationId, model, memberId);
		
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
			String check = reviewService.ReviewCheck(reservationId, model, memberId);
			if(check=="false") {
				return "false";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return "false";
		}
		return "true";
	}
	
	@GetMapping("/ReviewCheck2")
	@ResponseBody
	public String ReviewCheck2(@RequestParam String reservationId, Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("user");
		String check;
		
		try {
			reservationService.GetReservationInfo(reservationId, model);
			check = reviewService.ReviewCheck2(reservationId, model, memberId);
//			System.out.println("check="+check);
			if(check=="false") {
				return "false";
			}
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
	public String ReviewUpdate(@ModelAttribute Review review, @RequestParam String reservationId, Model model, HttpServletRequest request) {
		
		Reservation reservation = reservationService.GetReservationInfo(reservationId, model);
		String memberId = reservation.getMemberId();
		
		if(memberId.equals(review.getMemberId())) {
			reviewService.MemberReviewUpdate(review);
			reviewService.StarRateUpdate(review.getMemberId(), review, true);
		}
		else {
			reviewService.ReviewUpdate(review);
			reviewService.StarRateUpdate(review.getMemberId(), review, true);
		}
		
		return "redirect:/ReviewRead?reservationId="+reservationId;
	}
	
}
