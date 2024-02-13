package com.springmvc.repository;

import com.springmvc.domain.Member;

public interface MemberRepository {
	public Member Login(String memberId, String memberPw);
	public void join(Member member);
	public boolean idCheck(String memberId);
	public Member getMember(String memberId);
	public void updateMember(Member member, String memberId);
}
