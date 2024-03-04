package com.springmvc.service;

import java.util.List;
import java.util.Map;

import com.springmvc.domain.Mentor;
import com.springmvc.domain.MentorProfile;
import com.springmvc.domain.MentorRegistInfo;

public interface MentorService {
	public Mentor getMentor(String memberId);
	public void mentorApply(MentorRegistInfo mentorRegistInfo);
	public List<Map<String, Object>> getMentorApplyList();
	public List<Map<String, Object>> getMentorApplyList(String state);
	public List<Map<String, Object>> getMentorListWithMember();
	public List<Map<String, Object>> getMentorListWithMember(String state);
	public void mentorRegist(String memberId, String registId);
	public void mentorRefuse(String memberId, String registId);
	public Map<String, Object> getMentorApplyState(String memberId);
	public void mentorProfileRegister(MentorProfile mentorprofile, String memberId, String mentorId);
	public int getMentorProfile();
	public MentorProfile MentorInformation (String memberId);
	public void UpdateMentorProfile(MentorProfile mentorprofile,String memberId);
	public void DeleteMentorProfile(String memberId);
	public MentorRegistInfo getMentorApplyByRegistId(String registId);
	
}
