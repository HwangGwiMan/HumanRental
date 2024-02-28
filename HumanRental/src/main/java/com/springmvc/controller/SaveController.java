package com.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.Buying;
import com.springmvc.domain.Save;
import com.springmvc.service.BuyingService;
import com.springmvc.service.MemberService;
import com.springmvc.service.SaveService;

@Controller
@RequestMapping("/save")
public class SaveController {

	@Autowired
	MemberService memberService;
	
	@Autowired
	SaveService saveService;
	
	@Autowired
	BuyingService buyingService;
	
	List<Buying> wishList = new ArrayList<>();

	
	@GetMapping("/saveinsert")
	public String insertsavelist(@RequestParam("buyingId") String buyingId, Model model, HttpServletRequest request ) {
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("user");
		
		System.out.println(buyingId);
		System.out.println("인설트세이브리스트인데 여긴 올거니?");
		buyingService.BuyingDetailbyId(model, buyingId);
		
		Buying buying =(Buying)model.getAttribute("buying");
		System.out.println("인설트세이브리스트인데 여긴 올거니2?");

		 saveService.insertSavelist(buying,memberId);
			System.out.println("인설트세이브리스트인데 여긴 올거니3?");	
		return "redirect:/save/saveread";
	}
	@GetMapping("/saveread")
	public String moveSavelist(HttpServletRequest request ,Model model) {
	
		System.out.println("그럼 무브세이브리스트함수로 와줘");
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("user");
		
		List<Save> saveList = saveService.getsaveinformation(memberId);

	System.out.println("그럼 무브세이브리스트함수로 와줘222");

		model.addAttribute("saveList",saveList);
		
		return "Savelist";
	}
	
}
