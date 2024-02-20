package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Mentor getMentor(String memberId) {
		String SQL = "SELECT * FROM mentor WHERE memberId = ?";
	
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
		
		try {
			mentorRegistInfo.setRegistrId(util.createId("mentorApply"));
			
			SQL = "INSERT INTO mentorregistinfo VALUES(?, ?, ?, ?, ?, ?, ?)";
			template.update(SQL, mentorRegistInfo.getRegistrId(), mentorRegistInfo.getMemberId(), mentorRegistInfo.getSpecialty(), mentorRegistInfo.getLocation(), mentorRegistInfo.getReason(), mentorRegistInfo.getEtc(), LocalDateTime.now());
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Map<String, Object>> getMentorApplyList() {
		String SQL = "SELECT registId, mentorregistinfo.memberId, applyDate  , mentorId FROM mentorregistinfo "
				+ "LEFT JOIN mentor "
				+ "ON mentorregistinfo.memberId = mentor.memberId";
		
		try {
			return template.query(SQL, new RowMapper<Map<String, Object>>() {

				@Override
				public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
					Map<String, Object> applyList = new HashMap<String, Object>();
					applyList.put("registId", rs.getString(1));
					applyList.put("memberId", rs.getString(2));
					applyList.put("applyDate", rs.getTimestamp(3).toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")));
					applyList.put("mentorId", rs.getString(4));
					return applyList;
				}
				
			});
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			return null;
		}
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
	public List<Map<String, Object>> getMentorListWithMember() {
		String SQL = "SELECT mentor.mentorId, member.memberId, mentor.registDate, member.joinDate FROM member "
				+ "LEFT JOIN mentor "
				+ "ON member.memberId = mentor.memberId";
		
		
		try {
			return template.query(SQL, new RowMapper<Map<String, Object>>() {

				@Override
				public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
					Map<String, Object> memberInfo = new HashMap<String, Object>();
					memberInfo.put("mentorId", rs.getString(1));
					memberInfo.put("memberId", rs.getString(2));
					memberInfo.put("mentorRegistDate", rs.getString(3));
					memberInfo.put("memberJoinDate", rs.getString(4));
					
					return memberInfo;
				}
			});
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public void mentorRegist(String memberId) {
		String SQL;
		LocalDateTime joinDate;
		
		try {
			SQL = "SELECT joinDate FROM member WHERE memberId = ?";
			joinDate = template.query(SQL, new RowMapper<LocalDateTime>() {

				@Override
				public LocalDateTime mapRow(ResultSet rs, int rowNum) throws SQLException {
					return rs.getTimestamp("joinDate").toLocalDateTime();
				}
				
			}, memberId).get(0);
			
			SQL = "SELECT * FROM mentorregistinfo WHERE memberId = ?";
			
			SQL = "INSERT INTO mentor VALUES(?, ?, ?)";
			template.update(SQL, util.createId("mentor"), memberId, joinDate);
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
}
