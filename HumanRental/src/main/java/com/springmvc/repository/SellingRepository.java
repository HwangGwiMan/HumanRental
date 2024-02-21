package com.springmvc.repository;

import java.util.List;

import org.springframework.ui.Model;

import com.springmvc.domain.Selling;

public interface SellingRepository {
	public List<Selling> SellingList(Model model, String category);
	public void SellingCreate(Selling selling);
	public Selling SellingDetailbyId(String sellingId);
	public void SellingDelete(String sellingId);
	public void SellingUpdate(Selling selling);
}
