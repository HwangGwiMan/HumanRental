package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/main")
public class MainController {

@GetMapping("/alarm")
public String requestAlarm(Model model) {
		return "alarm";
	}

@GetMapping("/applyToMento")
public String requestApplyToMento(Model model) {
		return "applymento";
	}

@GetMapping("/buy")
public String requestBuy(Model model) {
	return "buy";
}

@GetMapping("/communitiy")
public String requestCommunitiy(Model model) {
	return "community";
}

@GetMapping("/give")
public String requestGive(Model model) {
		return "give";
	}
@GetMapping("/memberjoin")
public String requestMemberJoin(Model model) {
	return "memberJoin";
}

@GetMapping("/mypage")
public String requestMypage(Model model) {
	return "mypage";
}

@GetMapping("/sell")
public String requestSell(Model model) {
	return "sell";
}

@GetMapping("/trade")
public String requestTrade(Model model) {
		return "trade";
	}	
}
