package com.springmvc.service;

import javax.servlet.http.HttpServletRequest;

import com.springmvc.domain.Mentee;

public interface MenteeService {

	public void registerMentee(Mentee Mentee,HttpServletRequest request );
	public int getMentee(String memberId);
	public Mentee getInformation(String memberId);
	public Mentee UpdateMentee(Mentee Mentee,HttpServletRequest request);
	public void deleteMentee(HttpServletRequest request);
}
