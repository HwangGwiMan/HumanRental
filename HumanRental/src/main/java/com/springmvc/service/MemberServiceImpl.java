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
	public boolean Login(Member member) {
		return memberRepository.Login(member);
	}

	@Override
	public void join(Member member) {
	}

	
	@Override
	public String idCheck(String memberId) {
		return memberRepository.idCheck(memberId); 
	}
}
