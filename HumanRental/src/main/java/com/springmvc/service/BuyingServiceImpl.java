package com.springmvc.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.springmvc.domain.Buying;
import com.springmvc.domain.Selling;
import com.springmvc.repository.BuyingRepository;
import com.springmvc.util.Utility;

@Service
public class BuyingServiceImpl implements BuyingService{

	@Autowired
	BuyingRepository buyingrepository;
	
	Utility util = new Utility();

	@Override
	public void BuyingList(Model model, String category, int pageNum) {
		
		List<Buying> buyinglist = buyingrepository.BuyingList(category);
		List<Buying> targetlist = new ArrayList<Buying>();
		
		int startIdx = (pageNum - 1) * 16;
		int j = 0;
		for(int i = startIdx; i < buyinglist.size(); i++) {
			
			if(j >= 16) {
				break;
			}
			j++;
			
			try {
				targetlist.add(buyinglist.get(i));
			} catch(IndexOutOfBoundsException e) {
				break;
			}
		}
		
		model.addAttribute("buyinglist",targetlist);
		
		int totalPageNum = buyinglist.size() / 16 + 1;
		/*
		 * int[] pageNums = new int[totalPageNum];
		 * 
		 * for(int i = 1; i < totalPageNum + 1; i++) { pageNums[i - 1] = i; }
		 */
		
		
		
		model.addAttribute("totalPageNum", totalPageNum);
	}

	@Override
	public void BuyingList(Model model, String category) {
		List<Buying> buyinglist = buyingrepository.BuyingList(category);
		model.addAttribute("buyinglist",buyinglist);
	}

	@Override
	public void BuyingCreate(Buying buying) {
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
