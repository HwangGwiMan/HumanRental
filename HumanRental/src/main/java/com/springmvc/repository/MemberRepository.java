package com.springmvc.repository;

import com.springmvc.domain.Member;

public interface MemberRepository {
	public boolean Login(Member member);
	public boolean join(Member member);
	public boolean idCheck(String memberId);
}
