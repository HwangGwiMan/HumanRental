package com.springmvc.repository;

import java.util.List;

import org.springframework.ui.Model;

import com.springmvc.domain.Buying;
import com.springmvc.domain.Selling;

public interface SellingRepository {
	public List<Selling> SellingList(String category);
	public void SellingCreate(Selling selling);
	public Selling SellingDetailbyId(String sellingId);
	public void SellingDelete(String sellingId);
	public void SellingUpdate(Selling selling);
	public List<Selling> getSellingListById(String memberId);
	public List<Selling>  getSellingFromNickname(String nickname);
}
