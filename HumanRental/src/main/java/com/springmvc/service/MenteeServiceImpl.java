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
	public void registerMentee(Mentee Mentee ,String memberId) {
		MenteeRepository.registerMentee(Mentee, memberId);
		
	}

	@Override
	public boolean getMentee(String memberId) {
		return MenteeRepository.getMentee(memberId);
	}

	@Override
	public Mentee getInformation(String memberId){
		return MenteeRepository.getInformation(memberId);
	}

	@Override
	public Mentee UpdateMentee(Mentee Mentee,String memberId ) {
		return  MenteeRepository.UpdateMentee(Mentee,memberId);
	}

		
}
