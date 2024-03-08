package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.Member;

public interface MemberRepository {
	public Member Login(String memberId, String memberPw);
	public void join(Member member);
	public boolean idCheck(String memberId);
	public Member getMember(String memberId);
	public boolean deleteMember(String memberId, String memberPw);
	public void updateMember(Member member, String memberId);
	public List<Member> getMembers();
	public Member getMemberFromNickName(String nickname);
}
