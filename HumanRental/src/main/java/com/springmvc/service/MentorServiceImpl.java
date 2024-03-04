package com.springmvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Mentor;
import com.springmvc.domain.MentorProfile;
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
	public MentorRegistInfo getMentorApplyByRegistId(String registId) {
		return mentorRepository.getMentorApplyByRegistId(registId);
	}

	@Override
	public List<Map<String, Object>> getMentorListWithMember() {
		return mentorRepository.getMentorListWithMember();
	}
	

	@Override
	public List<Map<String, Object>> getMentorListWithMember(String state) {
		return mentorRepository.getMentorListWithMember(state);
	}

	@Override
	public List<Map<String, Object>> getMentorApplyList() {
		return mentorRepository.getMentorApplyList();
	}
	
	@Override
	public List<Map<String, Object>> getMentorApplyList(String state) {
		return mentorRepository.getMentorApplyList(state);
	}

	@Override
	public void mentorRegist(String memberId, String registId) {
		mentorRepository.mentorRegist(memberId, registId);		
	}

	@Override
	public void mentorRefuse(String memberId, String registId) {
		mentorRepository.mentorRefuse(memberId, registId);
	}

	@Override
	public Map<String, Object> getMentorApplyState(String memberId) {
		return mentorRepository.getMentorApplyState(memberId);
	}

	@Override
	public void mentorProfileRegister(MentorProfile mentorprofile , String memberId, String mentorId) {
		 mentorRepository.mentorProfileRegister(mentorprofile,memberId,mentorId);
	}

	@Override
	public int getMentorProfile() {
		return mentorRepository.getMentorProfile();
	}

	@Override
	public MentorProfile MentorInformation(String memberId) {
		return mentorRepository.MentorInformation(memberId);
	}
	
	public void UpdateMentorProfile(MentorProfile mentorprofile ,String memberId) {
		 mentorRepository.UpdateMentorProfile(mentorprofile ,memberId);
	}

	@Override
	public void DeleteMentorProfile(String memberId) {
		 mentorRepository.DeleteMentorProfile(memberId);
		
	}

}
