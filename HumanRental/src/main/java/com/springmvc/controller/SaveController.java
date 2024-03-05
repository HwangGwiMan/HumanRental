package com.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.domain.Buying;
import com.springmvc.domain.Reservation;
import com.springmvc.domain.Save;
import com.springmvc.domain.Selling;
import com.springmvc.service.AlarmService;
import com.springmvc.service.BuyingService;
import com.springmvc.service.MemberService;
import com.springmvc.service.ReservationService;
import com.springmvc.service.SaveService;
import com.springmvc.service.SellingService;

@Controller
@RequestMapping("/save")
public class SaveController {

	@Autowired
	MemberService memberService;
	
	@Autowired
	SaveService saveService;
	
	@Autowired
	BuyingService buyingService;
	
	@Autowired
	SellingService sellingService;
	
	@Autowired
	ReservationService reservationService;
	
	@Autowired
	AlarmService alarmScrvice;
	
	List<Buying> buyingWishList = new ArrayList<>();
	List<Selling> sellingWishList = new ArrayList<>();

	
	@GetMapping("/saveinsert")
	@ResponseBody
	public String insertsavelist(@RequestParam("savelistId") String savelistId, Model model, HttpServletRequest request ) {
		System.out.println("insertsavelist 있는 함수로 도착 했음 ");
		System.out.println("savelistId"+savelistId);
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("user");
		boolean a = saveService.checksaveinformation(memberId,savelistId);
		System.out.println(a);
		
		if(a==false) {
		    if(savelistId.contains("buying")) {
		        buyingService.BuyingDetailbyId(model, savelistId);
		        System.out.println("if문 뒤");  
		        Buying buying =(Buying)model.getAttribute("buying");
		        saveService.insertSavelist(buying,memberId);
		    }
		    else if(savelistId.contains("selling")) {
		        sellingService.SellingDetailbyId(model, savelistId);
		        Selling selling =(Selling)model.getAttribute("selling");
		        saveService.insertSavelist(selling,memberId);
		    }
		    return "redirect:/save/saveread"; 
		} else {
		    System.out.println("여긴 a값이 0보다 클 때 ");
		    return "false";
		}

		
	}

	@GetMapping("/saveread")
	public String moveSavelist(HttpServletRequest request ,Model model) {
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("user");
		
		List<Save> saveList = saveService.getsaveinformation(memberId);

		model.addAttribute("saveList",saveList);
		
		return "Savelist";
	}
	@GetMapping("/deletesavelist")
	public String deleteSavelist( @RequestParam("saveListId") String savelistid ,Model model) {
		 saveService.deletesavelist(savelistid);
				
		return "redirect:/save/saveread";
	}

	@PostMapping("/buying")
	public String BuyingReservation(@RequestParam("buyingId") String buyingId, Model model,
			@RequestParam("date") String date, @RequestParam("content") String content, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("user");
		Reservation reservation = reservationService.BuyingReservationCreate(buyingId, date, content, memberId, model);
		model.addAttribute("reservation", reservation);
		model.addAttribute("mode", "reservation");
		 saveService.deletesavelist(buyingId);
		return "CheckPage"; // 추후 예약 현황 페이지로
	}
	
	@PostMapping("/selling")
	public String SellingReservation(@RequestParam("sellingId") String sellingId, Model model,
			@RequestParam("date") String date, @RequestParam("content") String content, HttpServletRequest request) {
		System.out.println("SellingReservation 여기로 오니??");
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("user");
		Reservation reservation = reservationService.SellingReservationCreate(sellingId, date, content, memberId, model);
		model.addAttribute("reservation", reservation);
		model.addAttribute("mode", "reservation");
		 saveService.deletesavelist(sellingId);
		 System.out.println("이건 뭔 오류임?");
		 alarmScrvice.createReservationApplyAlarm(reservation);
		 System.out.println("이건 뭔 오류임2222?");

		return "CheckPage"; // 추후 예약 현황 페이지로
	}
	
	
}
