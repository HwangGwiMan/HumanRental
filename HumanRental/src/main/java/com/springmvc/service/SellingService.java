package com.springmvc.service;

import java.util.List;

import org.springframework.ui.Model;

import com.springmvc.domain.Selling;

public interface SellingService {
	public void SellingList(Model model, String category, int pageNum);
	public void SellingList(Model model, String category);
	public void SellingCreate(Selling selling);
	public void SellingDetailbyId(Model model, String sellingId);
	public void SellingDelete(String sellingId);
	public void SellingUpdate(Selling selling);
	public void getSellingListById(Model model, String memberId);
	public List<Selling> getSellingFromNickname( String nickname);
	

}
