package com.springmvc.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.springmvc.domain.Buying;
import com.springmvc.domain.Selling;
import com.springmvc.repository.SellingRepository;
import com.springmvc.util.Utility;

@Service
public class SellingServiceImpl implements SellingService{

	@Autowired
	SellingRepository sellingrepository;
	
	Utility util = new Utility();
	
	@Override
	public void SellingList(Model model, String category, int pageNum) {
		List<Selling> sellinglist = sellingrepository.SellingList(category);
		
		List<Selling> targetlist = new ArrayList<Selling>();
		
		int startIdx = (pageNum - 1) * 16;
		int j = 0;
		for(int i = startIdx; i < sellinglist.size(); i++) {
			
			if(j >= 16) {
				break;
			}
			j++;
			
			try {
				targetlist.add(sellinglist.get(i));
			} catch(IndexOutOfBoundsException e) {
				break;
			}
			
			
		}
		
		model.addAttribute("sellinglist",targetlist);
		
		
		int totalPageNum = sellinglist.size() / 16 + 1;
		/*
		 * int[] pageNums = new int[totalPageNum];
		 * 
		 * for(int i = 1; i < totalPageNum + 1; i++) { pageNums[i - 1] = i; }
		 */
		
		
		
		model.addAttribute("totalPageNum", totalPageNum);
	}
	
	@Override
	public void SellingList(Model model, String category) {
		List<Selling> sellinglist = sellingrepository.SellingList(category);
		model.addAttribute("sellinglist",sellinglist);
	}


	@Override
	public void SellingCreate(Selling selling) {

		//테스트코드
		selling.setStarRate(5);
		//
		
		selling.setRegist_day(LocalDateTime.now());
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


	@Override
	public void getSellingListById(Model model, String memberId) {
		List<Selling> sellinglist = sellingrepository.getSellingListById(memberId);
		model.addAttribute("sellinglist",sellinglist);
	}
	
	
	public List<Selling> getSellingFromNickname( String nickname) {
		return	sellingrepository.getSellingFromNickname(nickname);

	}

	
}
