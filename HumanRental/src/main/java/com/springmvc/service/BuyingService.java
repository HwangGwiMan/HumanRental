package com.springmvc.service;

import org.springframework.ui.Model;

import com.springmvc.domain.Buying;

public interface BuyingService {
	public void BuyingList(Model model, String category);
	public void BuyingCreate(Buying buying);
	public void BuyingDetailbyId(Model model, String buyingId);
	public void BuyingDelete(String buyingId);
	public void BuyingUpdate(Buying buying);
	public void getBuyingListById(Model model, String memberId);
}
