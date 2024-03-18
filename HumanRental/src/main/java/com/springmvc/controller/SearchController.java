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

	@GetMapping("/Search")
	public String getSearch(@RequestParam("search") String search, @RequestParam(defaultValue = "1") int page,
			Model model) {

		List<Buying> buyingAll = searchservice.getAllBuyingInformation(search);
		List<Selling> sellingAll = searchservice.getAllSellingInformation(search);
		List<Map<String,Object>>mentorprofileAll=searchservice.getAllMentorProfileInformaiton(search);
				
		//Buying 재능 구매
		int totalCount = buyingAll.size(); // 전체 항목 수
		int pageSize = 12; // 한 페이지에 표시할 항목 수
		int pageCount = (totalCount + pageSize - 1) / pageSize; // 페이지 수 계산

//		if (totalCount % pageSize != 0) {
//			pageCount++;
//		}

		List<Integer> pageNumbers = new ArrayList<>();
		for (int i = 1; i <= pageCount; i++) {
			pageNumbers.add(i);

		}
		model.addAttribute("pagenumbers", pageNumbers);

		if (page == 1) {

			List<Buying> buyingAll2 = searchservice.getAllBuyingInformationlimit(search, page);
			model.addAttribute("buying", buyingAll2);
		}

		else {

			List<Buying> buyingAll3 = searchservice.getAllBuyingInformationlimit(search, page);
			model.addAttribute("buying", buyingAll3);

		}


		//Selling재능 판매 
		int totalCount2 = sellingAll.size(); // 전체 항목 수
		int pageSize2 = 12; // 한 페이지에 표시할 항목 수
		int pageCount2 = (totalCount2 + pageSize2 - 1) / pageSize2; // 페이지 수 계산
		
		List<Integer> pageNumbers2 = new ArrayList<>();
		for (int i = 1; i <= pageCount2; i++) {
			pageNumbers2.add(i);

		}
		model.addAttribute("pagenumbers2", pageNumbers2);

		if (page == 1) {

			List<Selling> SellingAll2 = searchservice.getAllSellingInformationlimit(search, page);
			model.addAttribute("selling", SellingAll2);
		}

		else {

			List<Selling> SellingAll3 = searchservice.getAllSellingInformationlimit(search, page);
			model.addAttribute("selling", SellingAll3);

		}

		//멘토프로필 
		int totalCount3 = mentorprofileAll.size(); // 전체 항목 수
		int pageSize3 = 12; // 한 페이지에 표시할 항목 수
		int pageCount3 = (totalCount3 + pageSize3 - 1) / pageSize3; // 페이지 수 계산
		
		List<Integer> pageNumbers3 = new ArrayList<>();
		for (int i = 1; i <= pageCount3; i++) {
			pageNumbers3.add(i);

		}
		model.addAttribute("pagenumbers3", pageNumbers3);

		if (page == 1) {

			List<Map<String,Object>> mentorprofileAll2 = searchservice.getAllMentorprofileInformationlimit(search, page);
			model.addAttribute("mentorprofileAll", mentorprofileAll2);
		}

		else {

			List<Map<String,Object>> mentorprofileAll3 = searchservice.getAllMentorprofileInformationlimit(search, page);
			model.addAttribute("mentorprofileAll", mentorprofileAll3);

		}
		
		 
		  model.addAttribute("search", search);

		return "SearchPage";
	}

	@GetMapping("/Search123")
	public String Searchbyfield(@RequestParam("category") String category, @RequestParam("search") String search,
			Model model) {
		System.out.println("뜨고 있니??");
		List<Buying> buyingAll = searchservice.getAllBuyingInformation(search);
		List<Selling> sellingAll = searchservice.getAllSellingInformation(search);
		List<Map<String, Object>> mentorprofileAll = searchservice.getAllMentorProfileInformaiton(search);

		model.addAttribute("buying", buyingAll);
		model.addAttribute("selling", sellingAll);
		model.addAttribute("mentorprofileAll", mentorprofileAll);

		return "SearchPage";
	}

}
