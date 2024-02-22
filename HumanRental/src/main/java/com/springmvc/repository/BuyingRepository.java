package com.springmvc.repository;

import java.util.List;

import org.springframework.ui.Model;

import com.springmvc.domain.Buying;

public interface BuyingRepository {
	public List<Buying> BuyingList(String category);
	public void BuyingCreate(Buying buying);
	public Buying BuyingDetailbyId(String buyingId);
	public void BuyingDelete(String buyingId);
	public void BuyingUpdate(Buying buying);
}
