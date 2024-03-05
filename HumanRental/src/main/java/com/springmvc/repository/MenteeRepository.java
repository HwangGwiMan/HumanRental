package com.springmvc.repository;

import javax.servlet.http.HttpServletRequest;

import com.springmvc.domain.Member;
import com.springmvc.domain.Mentee;


public interface MenteeRepository {
	public void registerMentee(Mentee Mentee, String memberId);
	public boolean getMentee(String memberId);
	public Mentee getInformation(String memberId);
	public Mentee UpdateMentee(Mentee Mentee,String memberId);
	public Mentee getMentee2(String menteeId);
}
