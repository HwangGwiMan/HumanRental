package com.springmvc.service;

import com.springmvc.domain.Member;

public interface MemberService {
	public boolean Login(Member member);
	public boolean join(Member member);
	boolean idCheck(String memberId);
}
