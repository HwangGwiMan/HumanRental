package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.Mentee;

public class MenteeRowMapper implements RowMapper<Mentee>{
	
	public Mentee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Mentee mentee = new Mentee(); 
		mentee.setMenteeId(rs.getString("menteeId"));
		mentee.setMemberId(rs.getString("memberId"));
		mentee.setInterest(rs.getString("interest"));
		mentee.setIntroduction(rs.getString("introduction"));
		mentee.setStarRate(rs.getInt("starRate"));
 
		return mentee;
		 
	}

}
