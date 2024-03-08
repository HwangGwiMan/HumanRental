package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Buying;
import com.springmvc.domain.Selling;

public interface SearchService {

	public List<Buying>getAllBuyingInformation(String search,int pageSize,int totalcount);
	public List<Selling> getAllSellingInformation(String search);
	
	public List<Buying> getTitleBuyingInformation(String search);
	public List<Selling> getTitleSellingInformation(String search);
	
	public List<Buying> getContentBuyingInformation(String search);
	public List<Selling>getContentSellingInformation(String search);

	public List<Buying>getNicknameBuyingInformation(String search);
	public List<Selling>getNicknameSellingInformation(String search);

	public int CountGetAllBuyingInformation(String search);
}
