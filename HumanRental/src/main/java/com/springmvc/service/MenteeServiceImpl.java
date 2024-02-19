package com.springmvc.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Mentee;
import com.springmvc.repository.MenteeRepository;

@Service
public class MenteeServiceImpl implements MenteeService {

	@Autowired
    MenteeRepository MenteeRepository;

	@Override
	public void registerMentee(Mentee Mentee) {
		MenteeRepository.registerMentee(Mentee);
		
	}
	
	
	  public Mentee getMentee(Long MenteeId){
	  MenteeRepository.getMentee(MenteeId); 
	  }
	 
	
	
}
