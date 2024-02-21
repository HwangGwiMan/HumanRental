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
import com.springmvc.domain.Selling;
import com.springmvc.service.MemberService;
import com.springmvc.service.SellingService;

@Controller
public class SellingController {
	
	@Autowired
	SellingService sellingservice;
	
	@Autowired
	MemberService memberService;
	
	//멘티게시글 리스트 페이지
	@GetMapping("/SellingList")
	public String MentorList(@RequestParam(name = "category", required = false) String category, Model model) {
//		System.out.println("category : "+category);
		sellingservice.SellingList(model, category);
		return "SellingList";
	}
	
	//멘티게시글 상세페이지
	@GetMapping("/selling/detail")
	public String SellingDetail(@RequestParam("sellingId") String sellingId, Model model) {
		sellingservice.SellingDetailbyId(model, sellingId);
		return "SellingDetail";
	}
	
	@GetMapping("/selling")
	public String Selling(@ModelAttribute Selling selling, Model model, HttpServletRequest request) {
//		System.out.println("셀링 겟 접근");
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("user");
		Member member = memberService.getMember(memberId);
		model.addAttribute("member", member);
		model.addAttribute("type", "view");
		return "Selling";
	}
	
	@PostMapping("/selling")
	public String SellingCreate(@ModelAttribute Selling selling, Model model, HttpServletRequest request) {
//		System.out.println("셀링 포스트 접근");
		sellingservice.SellingCreate(selling);
		return "redirect:/SellingList";
	}
	
	@GetMapping("/selling/delete")
	public String SellingDelete(@RequestParam("sellingId") String sellingId) {
//		System.out.println("셀링 딜리트 접근");
		sellingservice.SellingDelete(sellingId);
		return "redirect:/SellingList";
	}
	
	@GetMapping("/selling/update")
	public String SellingUpdate(@ModelAttribute Selling selling, @RequestParam("sellingId") String sellingId, Model model) {
//		System.out.println("셀링 업데이트 겟 접근");
		sellingservice.SellingDetailbyId(model, sellingId);
		model.addAttribute("type", "update");
		return "Selling";
	}
	
	@PostMapping("/selling/update")
	public String SellingUpdateAction(@ModelAttribute Selling selling, Model model) {
//		System.out.println("셀링 업데이트 포스트 접근");
		sellingservice.SellingUpdate(selling);
		model.addAttribute("type", "view");
		return "redirect:/SellingList";
	}
}
