package com.springmvc.repository;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mysql.cj.protocol.Resultset;
import com.springmvc.domain.Mentee;
import com.springmvc.util.Utility;

@Repository
public class MenteeRepositoryImpl implements MenteeRepository{
	
	// JDBC
	private JdbcTemplate template;
				Resultset resultset;
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}



	public void registerMentee(Mentee mentee , String memberId) {

		  System.out.println("여기는 insert 구문이 있는 함수다 나와라 ");
		Utility utility = new Utility();
	 String utility2 =utility.createId("mentee");
		String SQL = "INSERT INTO MenteeProfile (menteeId, memberId, interest, introduction) VALUES(?,?,?,?)";
		template.update(SQL, utility2,memberId,mentee.getInterest(),mentee.getIntroduction());	
	}

	
	public boolean getMentee(String memberId) {
		Mentee mentee = null;
	    System.out.println("데이터 베이스에서 조회하는 함수인데 여긴 오니?");
	    System.out.println("memberId: " + memberId);
	    String SQL = "SELECT * from MenteeProfile where memberId = ?";

	    try {
	         mentee = template.queryForObject(SQL, new MenteeRowMapper(), memberId);
	        return true; // 조회 성공. Mentee 객체가 존재함.
	    } catch (EmptyResultDataAccessException e) {
	        return false; // 조회 실패. Mentee 객체가 존재하지 않음.
	    } catch(Exception e) {
	        e.printStackTrace(); // 그 외 예외 발생. 예외 내용 출력.
	        return false;
	    }
	}
	
	@Override
	public Mentee getInformation(String memberId) {
		Mentee mentee = null;
		System.out.println("그럼 이거는 데이터 베이스에서 셀렉하는 함수인데 여긴 오니?");
		String SQL = "select * from MenteeProfile where memberId=?";
	    mentee = template.queryForObject(SQL, new Object[]{memberId}, new MenteeRowMapper());
		return mentee;
	}
	@Override
	public Mentee UpdateMentee(Mentee Mentee,String memberId) {
		System.out.println("그럼 이거는 데이터 베이스에 업데이트하는 함수인데 여긴 오니?");

		  Mentee.setMemberId(memberId);
		  System.out.println(memberId);
		  String SQL = "UPDATE MenteeProfile SET interest = ?, introduction = ? WHERE memberId = ? ";
		  template.update(SQL,Mentee.getInterest(),Mentee.getIntroduction(),Mentee.getMemberId());
		return Mentee;
	}
//	@Override
//	public void deleteMentee( HttpServletRequest request) {
//		System.out.println("이거 데이터베이스에 멘티프로필 삭제하는 함수인데 여긴 오니?");
//		HttpSession session = request.getSession();
//		String memberId	= (String)session.getAttribute("user");
//		String SQL = "delete from MenteeProfile where memberId=?";  
//		template.update(SQL,memberId);
//	}
	
	public Mentee getMentee2(String menteeId) { // 예약 전용
		Mentee mentee = null;
//		System.out.println("겟멘티2 접근");
		String SQL = "select * from MenteeProfile where menteeId=?";
	    mentee = template.queryForObject(SQL, new MenteeRowMapper(), menteeId);
		return mentee;
	}
		 
}
