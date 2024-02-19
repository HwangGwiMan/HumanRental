package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.Member;
import com.springmvc.domain.Mentor;
import com.springmvc.domain.MentorProfile;
import com.springmvc.domain.MentorRegistInfo;

public interface MentorRepository {
	public MentorProfile getMentor(String memberId);
	public void mentorApply(MentorRegistInfo mentorRegistInfo);
	public List<MentorRegistInfo> getMentorApplyList();
	public MentorRegistInfo getMentorApplyByMemberId(String memberId);
	public List<Mentor> getMentorListWithMember();
}