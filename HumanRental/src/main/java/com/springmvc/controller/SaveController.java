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
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.domain.Buying;
import com.springmvc.domain.Save;
import com.springmvc.domain.Selling;
import com.springmvc.service.BuyingService;
import com.springmvc.service.MemberService;
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
	
		System.out.println("그럼 무브세이브리스트함수로 와줘");
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("user");
		
		List<Save> saveList = saveService.getsaveinformation(memberId);

	System.out.println("그럼 무브세이브리스트함수로 와줘222");

		model.addAttribute("saveList",saveList);
		
		return "Savelist";
	}
	@GetMapping("/deletesavelist")
	public String deleteSavelist( @RequestParam("saveListId") String savelistid ,Model model) {
		System.out.println("일단 여기는 와라 ");
		System.out.println("ㄳㄳ 와줘서");
		 saveService.deletesavelist(savelistid);
		
		
		return "redirect:/save/saveread";
	}

}
