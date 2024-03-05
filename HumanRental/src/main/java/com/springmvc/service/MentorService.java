package com.springmvc.service;

import java.util.List;
import java.util.Map;

import com.springmvc.domain.Mentor;
import com.springmvc.domain.MentorProfile;
import com.springmvc.domain.MentorRegistInfo;

public interface MentorService {
	public Mentor getMentor(String memberId);
	public void mentorApply(MentorRegistInfo mentorRegistInfo);
	public List<Map<String, Object>> getMentorApplyList(String sort, String sortTarget);
	public List<Map<String, Object>> getMentorApplyList(String state, String sort, String sortTarget);
	public List<Map<String, Object>> getMentorListWithMember(String sort, String sortTarget);
	public List<Map<String, Object>> getMentorListWithMember(String state, String sort, String sortTarget);
	public void mentorRegist(String memberId, String registId);
	public void mentorRefuse(String memberId, String registId);
	public Map<String, Object> getMentorApplyState(String memberId);
	public void mentorProfileRegister(MentorProfile mentorprofile, String memberId, String mentorId);
	public int getMentorProfile();
	public MentorProfile MentorprofileInformation (String memberId);
	public void UpdateMentorProfile(MentorProfile mentorprofile,String memberId);
	public void DeleteMentorProfile(String memberId);
	public MentorRegistInfo getMentorApplyByRegistId(String registId);
	public Map<String, Object> getMentorApplyByRegistIdTEST(String registId);

}
