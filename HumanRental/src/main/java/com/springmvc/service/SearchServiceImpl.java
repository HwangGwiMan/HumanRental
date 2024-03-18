package com.springmvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Buying;
import com.springmvc.domain.MentorProfile;
import com.springmvc.domain.Selling;
import com.springmvc.repository.SearchRepository;

@Service 
public class SearchServiceImpl implements  SearchService {
	 
	@Autowired
	SearchRepository searchrepository;
	
	//전체로 검색할때 쓰는 함수
	public List<Buying>getAllBuyingInformation(String search){
		
		return searchrepository.getAllBuyingInformation(search);
	}
	public List<Selling> getAllSellingInformation(String search){
		
		return searchrepository.getAllSellingInformation(search);

	}
	
	public List<Map<String, Object>>getAllMentorProfileInformaiton(String search){
		
		return searchrepository.getAllMentorProfileInformaiton(search);
	}

	
	
	@Override
	public List<Buying> getAllBuyingInformationlimit(String search, int page) {
		
		return searchrepository.getAllBuyingInformationlimit(search,page);

	}
	
	@Override
	public List<Selling> getAllSellingInformationlimit(String search, int page) {
		// TODO Auto-generated method stub
		return searchrepository.getAllSellingInformationlimit(search,page);
	}
	
	@Override
	public List<Map<String, Object>> getAllMentorprofileInformationlimit(String search, int page) {
		// TODO Auto-generated method stub
		return searchrepository.getAllMentorprofileInformationlimit(search,page);

	}

	

	
	
	
}
