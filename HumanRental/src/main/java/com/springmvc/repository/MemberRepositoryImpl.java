package com.springmvc.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.springmvc.domain.Member;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
	Map<String, String> members;
	boolean isIdCheck = false;
	
	public MemberRepositoryImpl() {
		super();
		this.members = new HashMap<String, String>();
		members.put("admin", "admin");
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
		members.put(member.getMemberId(), member.getMemberPw());
	}

	@Override
	public boolean idCheck(String memberId) {
		if(members.containsKey(memberId)) {
			return false; 
		} else {
			isIdCheck = true;
			return true;
		}
	}
}

