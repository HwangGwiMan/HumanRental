package com.springmvc.service;

import javax.servlet.http.HttpServletRequest;

import com.springmvc.domain.Mentee;



public interface MenteeService {

	public void registerMentee(Mentee mentee, String memberId);
	public boolean getMentee(String memberId);
	public Mentee getInformation(String memberId);
	public Mentee UpdateMentee(Mentee menteeprofile,String memberId);
}
