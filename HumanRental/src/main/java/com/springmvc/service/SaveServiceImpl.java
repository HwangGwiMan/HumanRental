package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Buying;
import com.springmvc.domain.Save;
import com.springmvc.repository.SaveRepository;

@Repository
public class SaveServiceImpl implements SaveService{
	
	@Autowired
	SaveRepository saveRepository;
	
	public  void insertSavelist(Buying buying ,String memberId) {
		saveRepository.insertSavelist(buying,memberId);
	};
	public List<Save> getsaveinformation(String memberId) {
		return saveRepository.getsaveinformation(memberId);
	}
	@Override
	public void deletesavelist(String savelistid) {
		 saveRepository.deletesavelist(savelistid);
		
	}
	
	
}
