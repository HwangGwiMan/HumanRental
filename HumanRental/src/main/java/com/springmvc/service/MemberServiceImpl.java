package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Member;
import com.springmvc.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;
	
	@Override
	public Member Login(String memberId, String memberPw) {
		return memberRepository.Login(memberId, memberPw);
	}

	@Override
	public void join(Member member) {
		memberRepository.join(member);
	}

	@Override
	public boolean idCheck(String memberId) {
		return memberRepository.idCheck(memberId); 
	}

	@Override
	public Member getMember(String memberId) {
		return memberRepository.getMember(memberId);
	}

	@Override
	public  boolean deleteMember(String memberId , String memberPw) {
		return memberRepository.deleteMember(memberId, memberPw);
	}
	
	public void updateMember(Member member, String memberId) {
		memberRepository.updateMember(member, memberId);
	}

	@Override
	public List<Member> getMembers() {
		return memberRepository.getMembers();
	}


}
