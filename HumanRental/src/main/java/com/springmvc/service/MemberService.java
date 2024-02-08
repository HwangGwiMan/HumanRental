package com.springmvc.service;

import com.springmvc.domain.Member;

public interface MemberService {
	public boolean Login(Member member);
	public void join(Member member);
	String idCheck(String memberId);
}
