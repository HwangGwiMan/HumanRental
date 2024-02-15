package com.springmvc.repository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Member;
import com.springmvc.domain.Mentor;
import com.springmvc.domain.MentorRegistInfo;

@Repository
public class MentorRepositroyImpl implements MentorRepository {
	
	// JDBC
	private JdbcTemplate template;
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Mentor getMentor(String memberId) {
		String SQL = "SELECT * FROM mentorprofile WHERE memberId = ?";
	
		try {
			List<Mentor> mentors = template.query(SQL, new BeanPropertyRowMapper<Mentor>(Mentor.class), memberId);
			return mentors.get(0);
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	@Override
	public void mentorApply(MentorRegistInfo mentorRegistInfo) {
		String SQL;
		
		List<MentorRegistInfo> mentorApplyList;
		long number;
		try {
			SQL = "SELECT * FROM mentorregistinfo";
			mentorApplyList = template.query(SQL, new BeanPropertyRowMapper<MentorRegistInfo>(MentorRegistInfo.class));
			number = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(); // 현재 시간 long로 변환
			mentorRegistInfo.setRegistrId("mentorApply_" + number);
			
			SQL = "INSERT INTO mentorregistinfo VALUES(?, ?, ?, ?, ?, ?)";
			template.update(SQL, mentorRegistInfo.getRegistrId(), mentorRegistInfo.getMemberId(), mentorRegistInfo.getSpecialty(), mentorRegistInfo.getLocation(), mentorRegistInfo.getReason(), mentorRegistInfo.getEtc());
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
}
