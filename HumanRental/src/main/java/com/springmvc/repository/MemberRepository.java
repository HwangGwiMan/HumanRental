package com.springmvc.repository;

import com.springmvc.domain.Member;

public interface MemberRepository {
	public boolean Login(Member member);
	public String join(Member member);
}
