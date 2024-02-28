package com.springmvc.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.springmvc.domain.Buying;
import com.springmvc.repository.BuyingRepository;
import com.springmvc.util.Utility;

@Service
public class BuyingServiceImpl implements BuyingService{

	@Autowired
	BuyingRepository buyingrepository;
	
	Utility util = new Utility();
	
	@Override
	public void BuyingList(Model model, String category) {
		List<Buying> buyinglist = buyingrepository.BuyingList(category);
		model.addAttribute("buyinglist",buyinglist);
	}


	@Override
	public void BuyingCreate(Buying buying) {

		//테스트코드
		buying.setStarRate(5);
		//
		
		buying.setRegist_day(LocalDateTime.now());
		buying.setBuyingId(util.createId("buyingId"));
		
		buyingrepository.BuyingCreate(buying);
	}


	@Override
	public void BuyingDetailbyId(Model model, String buyingId) {
		Buying buying = buyingrepository.BuyingDetailbyId(buyingId);
		model.addAttribute("buying",buying);
	}


	@Override
	public void BuyingDelete(String buyingId) {
		buyingrepository.BuyingDelete(buyingId);
	}


	@Override
	public void BuyingUpdate(Buying buying) {
		buyingrepository.BuyingUpdate(buying);
	}


	@Override
	public void getBuyingListById(Model model, String memberId) {
		List<Buying> buyinglist = buyingrepository.getBuyingListById(memberId);
		model.addAttribute("buyinglist",buyinglist);
	}
	
}
