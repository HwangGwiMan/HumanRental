package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.springmvc.domain.Selling;
import com.springmvc.repository.SellingRepository;
import com.springmvc.util.Utility;

@Service
public class SellingServiceImpl implements SellingService{

	@Autowired
	SellingRepository sellingrepository;
	
	Utility util = new Utility();
	
	@Override
	public void SellingList(Model model, String category) {
		List<Selling> sellinglist = sellingrepository.SellingList(model, category);
		model.addAttribute("sellinglist",sellinglist);
	}


	@Override
	public void SellingCreate(Selling selling) {
		
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy/MM/dd(HH:mm:ss)");
		String regist_day = formatter.format(new java.util.Date());

		//테스트코드
		selling.setStarRate(5);
		selling.setIntroduction("abc");
		//
		
		selling.setRegist_day(regist_day);
		selling.setSellingId(util.createId("sellingId"));
		
		sellingrepository.SellingCreate(selling);
	}


	@Override
	public void SellingDetailbyId(Model model, String sellingId) {
		Selling selling = sellingrepository.SellingDetailbyId(sellingId);
		model.addAttribute("selling",selling);
	}


	@Override
	public void SellingDelete(String sellingId) {
		sellingrepository.SellingDelete(sellingId);
	}


	@Override
	public void SellingUpdate(Selling selling) {
		sellingrepository.SellingUpdate(selling);
	}
	
	
	
}
