package com.springmvc.repository;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Member;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
	Map<String, String> members;
	boolean isIdCheck = false;
	
	// JDBC
	private JdbcTemplate template;
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
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
		String SQL = "INSERT INTO member VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		template.update(SQL, member.getMemberId(), member.getMemberPw(), member.getName(), member.getAge(), member.getGender(), member.getPhone(), member.getAddress());
		
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

