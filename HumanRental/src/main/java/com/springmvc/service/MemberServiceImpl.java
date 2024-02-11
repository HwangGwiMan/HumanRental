package com.springmvc.service;

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
}
