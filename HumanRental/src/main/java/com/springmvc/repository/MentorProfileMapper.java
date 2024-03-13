package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.Mentee;
import com.springmvc.domain.MentorProfile;

public class MentorProfileMapper implements RowMapper<MentorProfile> {

	public MentorProfile mapRow(ResultSet rs , int rowNum) throws SQLException{
		
		MentorProfile mentorprofile = new MentorProfile();
		mentorprofile.setCategory(rs.getString("category"));
		mentorprofile.setCertification(rs.getString("certification"));
		mentorprofile.setFilename1(rs.getString("filename1"));
		mentorprofile.setFilename2(rs.getString("filename2"));
		mentorprofile.setFilename3(rs.getString("filename3"));
		mentorprofile.setIntroduction(rs.getString("introduction"));
		mentorprofile.setMemberId(rs.getString("memberId"));
		mentorprofile.setMentorId(rs.getString("mentorId"));
		mentorprofile.setStarRate(rs.getFloat("starRate"));
		mentorprofile.setStarCount(rs.getInt("starCount"));
		mentorprofile.setMentorprofileaddress(rs.getString("mentorprofileaddress"));
		 return mentorprofile;
	}
	
	

	
}
