package com.springmvc.controller;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.Buying;
import com.springmvc.domain.MentorProfile;
import com.springmvc.domain.Save;
import com.springmvc.domain.Selling;
import com.springmvc.service.MemberService;
import com.springmvc.service.SearchService;


@Controller
public class SearchController {
	
	@Autowired
	SearchService searchservice;

	@Autowired
	MemberService memberservice;
		
	@PostMapping("/Search")
	public String getSearch(@RequestParam("search") String search, @RequestParam("items") String items, @RequestParam(value = "page", defaultValue = "1") int page,
	        Model model) {

	    int pageSize = 10;
	    int totalcount = searchservice.CountGetAllBuyingInformation(search);
	    int totalPages = (int) Math.ceil((double) totalcount / pageSize);

	    switch (items) {
	        case "all":
	            List<Buying> buyingAll = searchservice.getAllBuyingInformation(search, page, pageSize);
	            List<Selling> sellingAll = searchservice.getAllSellingInformation(search);
	            List<Map<String,Object>>mentorprofileAll=searchservice.getAllMentorProfileInformaiton(search);

	            model.addAttribute("page", page);
	            model.addAttribute("totalPages", totalPages);
	            model.addAttribute("buying", buyingAll);
	            model.addAttribute("selling", sellingAll);
	            model.addAttribute("mentorprofileAll",mentorprofileAll);
	            break;
	        // ...
	        case "title":
	            // 내용을 검색하는 로직을 여기에 구현
	            List<Buying> buyingTitle = searchservice.getTitleBuyingInformation(search);
	            List<Selling> sellingTitle = searchservice.getTitleSellingInformation(search);
	            model.addAttribute("buying", buyingTitle);
	            model.addAttribute("selling", sellingTitle);
	            System.out.println("title");
	            break;
	        case "content":
	            // 내용을 검색하는 로직을 여기에 구현
	            List<Buying> buyingContent = searchservice.getContentBuyingInformation(search);
	            List<Selling> sellingContent = searchservice.getContentSellingInformation(search);
	            model.addAttribute("buying", buyingContent);
	            model.addAttribute("selling", sellingContent);
	            System.out.println("content");
	            break;
	        case "nickname":
	            // 닉네임을 검색하는 로직을 여기에 구현
	            List<Buying> buyingNickname = searchservice.getNicknameBuyingInformation(search);
	            List<Selling> sellingNickname = searchservice.getNicknameSellingInformation(search);
	            model.addAttribute("buying", buyingNickname);
	            model.addAttribute("selling", sellingNickname);
	            System.out.println("nickname");
	            break;
	            
	    }

	    return "SearchPage";
	}
}
