package com.springmvc.repository;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
	public MenteeRepositoryImpl() {
		super();
	}

		

	public void registerMentee(Mentee Mentee , HttpServletRequest request) {
		  HttpSession session = request.getSession();
		  String memberId	= (String)session.getAttribute("user");
		  System.out.println(memberId);
		  Mentee.setMemberId(memberId);
		  System.out.println("여기는 insert 구문이 있는 함수다 나와라 ");
		Utility utility = new Utility();
	 String utility2 =utility.createId("menteeProfile");
		String SQL = "INSERT INTO MenteeProfile (menteeId,memberId,interest,introduction) VALUES(?,?,?,?)";
		template.update(SQL, utility2,Mentee.getMemberId(),Mentee.getInterest(),Mentee.getIntroduction());	
	}

	
	public int getMentee(String memberId) 
	{
		System.out.println("데이터 베이스에서 조회하는 함수인데   함수인데 여긴 오니?");
		String SQL= "SELECT count(*) from MenteeProfile where memberId=?";     
		 int rowCount = template.queryForObject(SQL, new Object[]{memberId}, Integer.class);
		 return rowCount;

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
	public Mentee UpdateMentee(Mentee Mentee, HttpServletRequest request) {
		System.out.println("그럼 이거는 데이터 베이스에 업데이트하는 함수인데 여긴 오니?");
		  HttpSession session = request.getSession();
		  String memberId	= (String)session.getAttribute("user");
		  Mentee.setMemberId(memberId);
		  System.out.println(memberId);
		  String SQL = "UPDATE MenteeProfile SET interest = ?, introduction = ? WHERE memberId = ? ";
		  template.update(SQL,Mentee.getInterest(),Mentee.getIntroduction(),Mentee.getMemberId());
		return Mentee;
	}
	@Override
	public void deleteMentee( HttpServletRequest request) {
		System.out.println("이거 데이터베이스에 멘티프로필 삭제하는 함수인데 여긴 오니?");
		HttpSession session = request.getSession();
		String memberId	= (String)session.getAttribute("user");
		String SQL = "delete from MenteeProfile where memberId=?";  
		template.update(SQL,memberId);
	}

}
