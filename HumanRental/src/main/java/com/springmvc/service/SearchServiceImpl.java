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
	public List<Buying>getAllBuyingInformation(String search,int pageSize,int totalcount){
		
		return searchrepository.getAllBuyingInformation(search,pageSize,totalcount);
	}
	public List<Selling> getAllSellingInformation(String search){
		
		return searchrepository.getAllSellingInformation(search);

	}
	
	public List<Map<String, Object>>getAllMentorProfileInformaiton(String search){
		
		return searchrepository.getAllMentorProfileInformaiton(search);
	}

	
	
	
	//제목으로 검색할때 쓰는 함수 
	public List<Buying> getTitleBuyingInformation(String search){
		
		return searchrepository.getTitleBuyingInformation(search);
	};

	public List<Selling>getTitleSellingInformation(String search){
		
		return searchrepository.getTitleSellingInformation(search);

	};
	
	//내용으로 검색할때 쓰는 함수 
	public List<Buying>getContentBuyingInformation(String search){
		
		return searchrepository.getContentBuyingInformation(search);

	}
	
	public List<Selling>getContentSellingInformation(String search){
		
		return searchrepository.getContentSellingInformation(search);
	}
	
	//닉네임으로 검색할때 쓰는 함수
	public List<Buying>getNicknameBuyingInformation(String search){
		
		return searchrepository.getNicknameBuyingInformation(search);

	}

	public List<Selling>getNicknameSellingInformation(String search){
		
		return searchrepository.getNicknameSellingInformation(search);

	}

	public int CountGetAllBuyingInformation(String search) {
		
		return searchrepository.CountGetAllBuyingInformation(search);

	}


	
	
	
}
