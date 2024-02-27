package com.springmvc.repository;

import javax.servlet.http.HttpServletRequest;

import com.springmvc.domain.Member;
import com.springmvc.domain.Mentee;

public interface MenteeRepository {
	public void registerMentee(Mentee Mentee,HttpServletRequest request);
	public int getMentee(String memberId);
	public Mentee getInformation(String memberId);
	public Mentee UpdateMentee(Mentee Mentee,HttpServletRequest request);
	public void deleteMentee(HttpServletRequest request);
	public Mentee getMentee2(String menteeId);
}
