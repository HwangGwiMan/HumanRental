package com.springmvc.service;

import com.springmvc.domain.Mentee;

public interface MenteeService {

	public void registerMentee(Mentee Mentee);
	public Mentee getMentee(Long MenteeId);
}
