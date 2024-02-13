package com.springmvc.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Member;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

	// JDBC
	private JdbcTemplate template;
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	public MemberRepositoryImpl() {
		super();
	}
	
	// 로그인 
	@Override
	public Member Login(String memberId, String memberPw) {
		String SQL = "SELECT * FROM member WHERE memberId = ? and memberPw = ?";
		
		List<Member> loginMember;
		
		try {
			loginMember = template.query(SQL, new BeanPropertyRowMapper<Member>(Member.class), memberId, memberPw);
			return loginMember.get(0);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	// 회원 가입
	@Override
	public void join(Member member) {
		String SQL = "INSERT INTO member VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		template.update(SQL, member.getMemberId(), member.getMemberPw(), member.getName(), member.getAge(), member.getGender(), member.getPhone(), member.getAddress(), member.getNickName());
	}
	
	// 아이디 중복 확인
	@Override
	public boolean idCheck(String memberId) {
		String SQL = "SELECT * FROM member WHERE memberId = ?";
		
//		List<Member> isMember = template.query(SQL, new RowMapper<Member>() {
//
//			@Override
//			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Member member = new Member();
//				member.setMemberId(rs.getString("memberId"));
//				member.setMemberPw(rs.getString("memberPw"));
//				return member;
//			}
//			
//		}, memberId);
		
		try {
			template.queryForMap(SQL, memberId);
			return false;
		} catch(EmptyResultDataAccessException e) {
			return true;
		}
		
//		if(members.containsKey(memberId)) {
//			return false; 
//		} else {
//			isIdCheck = true;
//			return true;
//		}
//	}
	}

	@Override
	public Member getMember(String memberId) {
		String SQL = "SELECT * FROM member WHERE memberId = ?";
		
		List<Member> member;
		
		try {
			member = template.query(SQL, new BeanPropertyRowMapper<Member>(Member.class), memberId);
			return member.get(0);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
}
