package com.springmvc.service;

import java.util.List;
import java.util.Map;

import com.springmvc.domain.Buying;
import com.springmvc.domain.MentorProfile;
import com.springmvc.domain.Selling;

public interface SearchService {

	public List<Buying>getAllBuyingInformation(String search);
	public List<Selling> getAllSellingInformation(String search);
	public List<Map<String, Object>>getAllMentorProfileInformaiton(String search);
	
	public List<Buying>getAllBuyingInformationlimit(String search, int page);
	public List<Selling> getAllSellingInformationlimit(String search, int page);
	public List<Map<String, Object>>getAllMentorprofileInformationlimit(String search, int page);
	
//	public List<Buying> getTitleBuyingInformation(String search);
//	public List<Selling> getTitleSellingInformation(String search);
//	
//	public List<Buying> getContentBuyingInformation(String search);
//	public List<Selling>getContentSellingInformation(String search);
//
//	public List<Buying>getNicknameBuyingInformation(String search);
//	public List<Selling>getNicknameSellingInformation(String search);

	
}
