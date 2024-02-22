package com.springmvc.service;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Mentee;
import com.springmvc.repository.MenteeRepository;

@Service
public class MenteeServiceImpl implements MenteeService {

	@Autowired
    MenteeRepository MenteeRepository;

	@Override
	public void registerMentee(Mentee Mentee ,HttpServletRequest request) {
		MenteeRepository.registerMentee(Mentee,request);
		
	}

	@Override
	public int getMentee(String memberId) {
		return MenteeRepository.getMentee(memberId);
	}

	@Override
	public Mentee getInformation(String memberId){
		return MenteeRepository.getInformation(memberId);
	}

	@Override
	public Mentee UpdateMentee(Mentee Mentee, HttpServletRequest request) {
		return  MenteeRepository.UpdateMentee(Mentee,request);
	}

	@Override
	public void deleteMentee(HttpServletRequest request) {
		 MenteeRepository.deleteMentee(request);
	}
	
}
