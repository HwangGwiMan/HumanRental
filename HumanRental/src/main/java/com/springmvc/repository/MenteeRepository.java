package com.springmvc.repository;

import com.springmvc.domain.Member;
import com.springmvc.domain.Mentee;

public interface MenteeRepository {
	public void registerMentee(Mentee Mentee);
	public Mentee getMentee(Long MenteeId);
}
