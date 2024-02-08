package com.springmvc.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.springmvc.domain.Member;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
	Map<String, String> members;

	public MemberRepositoryImpl() {
		super();
		this.members = new HashMap<String, String>();
	}

	@Override
	public boolean Login(Member member) {
		if(members.containsKey(member.getMemberId())) {
			if(members.get(member.getMemberId()).equals(member.getMemberPw())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public void join(Member member) {
	}

	@Override
	public String idCheck(String memberId) {
		if(members.containsKey(memberId)) {
			return "이미 존재하는 아이디입니다"; 
		} else {
			return "사용 가능한 아이디 입니다";
		}
	}
}

