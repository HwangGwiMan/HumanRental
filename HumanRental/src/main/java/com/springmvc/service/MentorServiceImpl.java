package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Mentor;
import com.springmvc.domain.MentorRegistInfo;
import com.springmvc.repository.MentorRepository;

@Service
public class MentorServiceImpl implements MentorService {
	
	@Autowired
	MentorRepository mentorRepository;
	
	@Override
	public Mentor getMentor(String memberId) {
		return mentorRepository.getMentor(memberId);
	}

	@Override
	public void mentorApply(MentorRegistInfo mentorRegistInfo) {
		mentorRepository.mentorApply(mentorRegistInfo);
	}

	@Override
	public MentorRegistInfo getMentorApplyByMemberId(String memberId) {
		return mentorRepository.getMentorApplyByMemberId(memberId);
	}
	

}
