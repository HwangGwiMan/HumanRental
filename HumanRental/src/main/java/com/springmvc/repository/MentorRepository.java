package com.springmvc.repository;

import com.springmvc.domain.Member;
import com.springmvc.domain.Mentor;

public interface MentorRepository {
	public Mentor getMentor(String memberId);
}