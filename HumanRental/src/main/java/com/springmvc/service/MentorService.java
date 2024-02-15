package com.springmvc.service;

import com.springmvc.domain.Mentor;
import com.springmvc.domain.MentorRegistInfo;

public interface MentorService {
	public Mentor getMentor(String memberId);
	public void mentorApply(MentorRegistInfo mentorRegistInfo);
}
