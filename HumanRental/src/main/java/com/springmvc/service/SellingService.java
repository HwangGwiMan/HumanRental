package com.springmvc.service;

import org.springframework.ui.Model;

import com.springmvc.domain.Selling;

public interface SellingService {
	public void SellingList(Model model, String category);
	public void SellingCreate(Selling selling);
	public void SellingDetailbyId(Model model, String sellingId);
	public void SellingDelete(String sellingId);
	public void SellingUpdate(Selling selling);
	public void getSellingListById(Model model, String memberId);
}
