package com.springmvc.repository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Member;
import com.springmvc.domain.Mentor;
import com.springmvc.domain.MentorProfile;
import com.springmvc.domain.MentorRegistInfo;
import com.springmvc.util.Utility;

@Repository
public class MentorRepositroyImpl implements MentorRepository {
	
	@Autowired
	AlarmRepository alarmRepository;
	
	Utility util = new Utility(); 
	
	// JDBC
	private JdbcTemplate template;
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public MentorProfile getMentor(String memberId) {
		String SQL = "SELECT * FROM mentorprofile WHERE memberId = ?";
	
		try {
			List<MentorProfile> mentors = template.query(SQL, new BeanPropertyRowMapper<MentorProfile>(MentorProfile.class), memberId);
			return mentors.get(0);
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	@Override
	public void mentorApply(MentorRegistInfo mentorRegistInfo) {
		String SQL;
		
		try {
			mentorRegistInfo.setRegistrId(util.createId("mentorApply"));
			
			SQL = "INSERT INTO mentorregistinfo VALUES(?, ?, ?, ?, ?, ?, ?)";
			template.update(SQL, mentorRegistInfo.getRegistrId(), mentorRegistInfo.getMemberId(), mentorRegistInfo.getSpecialty(), mentorRegistInfo.getLocation(), mentorRegistInfo.getReason(), mentorRegistInfo.getEtc(), LocalDateTime.now());
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MentorRegistInfo> getMentorApplyList() {
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

	@Override
	public List<Mentor> getMentorListWithMember() {
		String SQL = "select mentor.mentorId, member.memberId, mentor.registDate from member "
				+ "Left join mentor "
				+ "on member.memberId = mentor.memberId";
		
		try {
			return template.query(SQL, new BeanPropertyRowMapper<Mentor>(Mentor.class));
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			return null;
		}
	}
}
