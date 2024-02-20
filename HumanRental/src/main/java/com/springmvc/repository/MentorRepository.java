package com.springmvc.repository;

import java.util.List;
import java.util.Map;

import com.springmvc.domain.Member;
import com.springmvc.domain.Mentor;
import com.springmvc.domain.MentorProfile;
import com.springmvc.domain.MentorRegistInfo;

public interface MentorRepository {
	public Mentor getMentor(String memberId);
	public void mentorApply(MentorRegistInfo mentorRegistInfo);
	public List<Map<String, Object>> getMentorApplyList();
	public MentorRegistInfo getMentorApplyByMemberId(String memberId);
	public List<Map<String, Object>> getMentorListWithMember();
	public void mentorRegist(String memberId);
}