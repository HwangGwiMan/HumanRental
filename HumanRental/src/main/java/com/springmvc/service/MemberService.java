package com.springmvc.service;

import com.springmvc.domain.Member;

public interface MemberService {
	public Member Login(String memberId, String memberPw);
	public void join(Member member);
	boolean idCheck(String memberId);
}
