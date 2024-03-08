package com.springmvc.repository;

import java.time.LocalDateTime;
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
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	// 회원 가입
	@Override
	public void join(Member member) {
		System.out.println("회원가입");
		String SQL = "INSERT INTO member (memberId, memberPw, name, age, gender, phone, address, nickName, joinDate, profileImage, reportCount) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		template.update(SQL, member.getMemberId(), member.getMemberPw(), member.getName(), member.getAge(), member.getGender(), member.getPhone(), member.getAddress(), member.getNickName(), LocalDateTime.now() ,"default.png", 0);
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
	
	// 회원 정보 획득
	@Override
	public Member getMember(String memberId) {
		String SQL = "SELECT * FROM member WHERE memberId = ?";
		
		List<Member> member;
		
		try {
			member = template.query(SQL, new BeanPropertyRowMapper<Member>(Member.class), memberId);
			return member.get(0);
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			return null;
		}
	}
  

	
	@Override
	public List<Member> getMembers() {
		String SQL = "SELECT * FROM member";
		
		List<Member> members;
		
		try {
			members = template.query(SQL, new BeanPropertyRowMapper<Member>(Member.class));
			return members;
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	//회원탈퇴
	public boolean deleteMember(String memberId , String memberPw) {
	    String SQL = "delete from member where memberId=? and memberPw=?";
	    try {
	        int updatedRows = template.update(SQL, memberId, memberPw);
	        // 성공적으로 삭제된 행의 수가 0보다 크면 true, 아니면 false를 반환합니다.
	        return updatedRows > 0;
	    } catch (Exception e) {
	        // SQL 실행 오류를 잡습니다.
	        // 이 경우에는 false를 반환하거나, 필요에 따라 적절한 예외 처리를 수행합니다.
	        System.out.println("회원 탈퇴 중 오류가 발생했습니다: " + e.getMessage());
	        return false;
	    }
	}
	// 회원 정보 수정
	@Override
	public void updateMember(Member member, String memberId) {
		String SQL = "UPDATE member set memberId = ?, memberPw = ?,  name = ?, age = ?, gender = ?, phone = ?, address = ?, nickName = ?, profileImage = ? WHERE memberId = ?";	
		template.update(SQL, member.getMemberId(), member.getMemberPw(), member.getName(), member.getAge(), member.getGender(), member.getPhone(), member.getAddress(), member.getNickName(), member.getProfileImage(), memberId);
	}
	
	//닉네임으로 회원정보 획득 
	public Member getMemberFromNickName(String nickname) {
		String SQL = "SELECT * FROM member WHERE nickname = ?";
		List<Member> member2;
		try {
			member2 = template.query(SQL, new BeanPropertyRowMapper<Member>(Member.class), nickname);
			return member2.get(0);
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			return null;
		}
	}
}

