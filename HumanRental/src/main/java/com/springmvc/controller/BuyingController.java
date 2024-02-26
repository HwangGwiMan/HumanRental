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
import com.springmvc.service.BuyingService;

@Controller
public class BuyingController {
	
	@Autowired
	BuyingService buyingservice;
	
	@Autowired
	MemberService memberService;
	
	//멘티게시글 리스트 페이지
	@GetMapping("/BuyingList")
	public String MentorList(@RequestParam(name = "category", required = false) String category, Model model) {
//		System.out.println("category : "+category);
		buyingservice.BuyingList(model, category);
		return "BuyingList";
	}
	
	//멘티게시글 상세페이지
	@GetMapping("/buying/detail")
	public String BuyingDetail(@RequestParam("buyingId") String buyingId, Model model) {
		buyingservice.BuyingDetailbyId(model, buyingId);
		return "BuyingDetail";
	}
	
	@GetMapping("/buying")
	public String Buying(@ModelAttribute Buying buying, Model model, HttpServletRequest request) {
//		System.out.println("셀링 겟 접근");
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("user");
		Member member = memberService.getMember(memberId);
		model.addAttribute("member", member);
		model.addAttribute("type", "view");
		return "Buying";
	}
	
	@PostMapping("/buying")
	public String BuyingCreate(@ModelAttribute Buying buying, Model model, HttpServletRequest request) {
//		System.out.println("셀링 포스트 접근");
		buyingservice.BuyingCreate(buying);
		return "redirect:/BuyingList";
	}
	
	@GetMapping("/buying/delete")
	public String BuyingDelete(@RequestParam("buyingId") String buyingId) {
//		System.out.println("셀링 딜리트 접근");
		buyingservice.BuyingDelete(buyingId);
		return "redirect:/BuyingList";
	}
	
	@GetMapping("/buying/update")
	public String BuyingUpdate(@ModelAttribute Buying buying, @RequestParam("buyingId") String buyingId, Model model) {
//		System.out.println("셀링 업데이트 겟 접근");
		buyingservice.BuyingDetailbyId(model, buyingId);
		model.addAttribute("type", "update");
		return "Buying";
	}
	
	@PostMapping("/buying/update")
	public String BuyingUpdateAction(@ModelAttribute Buying buying, Model model) {
//		System.out.println("셀링 업데이트 포스트 접근");
		buyingservice.BuyingUpdate(buying);
		model.addAttribute("type", "view");
		return "redirect:/BuyingList";
	}
	
	@GetMapping("/buyingListManagement")
	public String BuyingListManagement(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("user");
		buyingservice.getBuyingListById(model, memberId);
		model.addAttribute("mode", "buyingListManagement");
		return "MyPage";
	}
}
