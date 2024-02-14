package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Mentor;
import com.springmvc.repository.MentorRepository;

@Service
public class MentorServiceImpl implements MentorService {
	
	@Autowired
	MentorRepository mentoreRepository;
	
	@Override
	public Mentor getMentor(String memberId) {
		return mentoreRepository.getMentor(memberId);
	}

}
