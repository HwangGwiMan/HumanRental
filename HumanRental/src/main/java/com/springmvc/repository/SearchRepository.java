package com.springmvc.repository;

import java.util.List;
import java.util.Map;

import com.springmvc.domain.Buying;
import com.springmvc.domain.MentorProfile;
import com.springmvc.domain.Selling;

public interface SearchRepository {

	public List<Buying>getAllBuyingInformation(String search);
	public List<Selling>getAllSellingInformation(String search);
	public List<Map<String, Object>>getAllMentorProfileInformaiton(String search);
	
	public List<Buying> getAllBuyingInformationlimit(String search, int page); 
	public List<Selling> getAllSellingInformationlimit(String search, int page);
	public List<Map<String, Object>>getAllMentorprofileInformationlimit(String search, int page);

	
	
	
	
	

}
