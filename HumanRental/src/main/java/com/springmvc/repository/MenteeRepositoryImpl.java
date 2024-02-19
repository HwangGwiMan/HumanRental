package com.springmvc.repository;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mysql.cj.protocol.Resultset;
import com.springmvc.domain.Mentee;

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

		
	public void registerMentee(Mentee Mentee) {
		Long number = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(); // 현재 시간 long로 변환
		Mentee.setMenteeId(number);
		String SQL = "INSERT INTO MenteeProfile (menteeId,memberId,introduction) VALUES(?,?,?)";
		template.update(SQL, Mentee.getMenteeId(), Mentee.getMemberId(), Mentee.getIntroduction());	
	}
	
	/*public Book getBookById(String bookId)
	{
		System.out.println(bookId);
		Book bookInfo = null;
	    String SQL = "SELECT count(*) FROM book where b_bookId=?"; 
	        int rowCount = template.queryForObject(SQL, Integer.class, bookId); 
	        if (rowCount != 0) {
	            SQL = "SELECT * FROM book where b_bookId=?"; 
	            bookInfo = template.queryForObject(SQL, new Object[] { bookId }, new BookRowMapper()); 
	        }
	*/
	
	
	public Mentee getMentee(Long menteeId)
	{
		System.out.println(menteeId);
		Mentee mentee= null;
	    String SQL= "SELECT count(*) from MenteeProfile where menteeId=?";
	    int rowCount = template.queryForObject(SQL, Integer.class, menteeId); 
	    if (rowCount != 0) {
	    	SQL = "SELECT * FROM MenteeProfile WHERE menteeId=?";
	    	mentee = template.queryForObject(SQL, new Object[] { menteeId }, new MenteeRowMapper());
        }
	            // 기타 필드를 설정합니다.
	            return mentee;
	        }
	 
	}
	 

