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
import com.springmvc.util.Utility;

@Repository
public class MentorRepositroyImpl implements MentorRepository {
	
	Utility util = new Utility(); 
	
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
		try {
			mentorRegistInfo.setRegistrId(util.createId("mentorApply"));
			
			SQL = "INSERT INTO mentorregistinfo VALUES(?, ?, ?, ?, ?, ?)";
			template.update(SQL, mentorRegistInfo.getRegistrId(), mentorRegistInfo.getMemberId(), mentorRegistInfo.getSpecialty(), mentorRegistInfo.getLocation(), mentorRegistInfo.getReason(), mentorRegistInfo.getEtc());
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MentorRegistInfo> mentorApplyList() {
		String SQL = "SELECT * FROM mentorregistinfo";
		return template.query(SQL, new BeanPropertyRowMapper<MentorRegistInfo>(MentorRegistInfo.class));
	}

	@Override
	public MentorRegistInfo getMentorApplyByMemberId(String memberId) {
		String SQL = "SELECT * FROM mentorregistinfo WHERE memberId = ?";
		try {
			List<MentorRegistInfo> mentorApplyList = template.query(SQL, new BeanPropertyRowMapper<MentorRegistInfo>(MentorRegistInfo.class), memberId);
			return mentorApplyList.get(0);
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			return null;
		}
	}
}
