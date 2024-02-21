package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Formatter;
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
	
	// 멘토 정보
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
	
	// 멘토 신청
	@Override
	public void mentorApply(MentorRegistInfo mentorRegistInfo) {
		String SQL;
		
		try {
			mentorRegistInfo.setRegistId(util.createId("mentorApply"));
			
			SQL = "INSERT INTO mentorregistinfo VALUES(?, ?, ?, ?, ?, ?, ?)";
			template.update(SQL, mentorRegistInfo.getRegistId(), mentorRegistInfo.getMemberId(), mentorRegistInfo.getSpecialty(), mentorRegistInfo.getLocation(), mentorRegistInfo.getReason(), mentorRegistInfo.getEtc(), LocalDateTime.now());
			
			SQL = "INSERT INTO mentorapply VALUES(?, ?, ?, ?)";
			template.update(SQL, mentorRegistInfo.getRegistId(), mentorRegistInfo.getMemberId(), null, "Wait");
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
	
	// 멘토 신청 리스트
	@Override
	public List<Map<String, Object>> getMentorApplyList() {
		String SQL = "SELECT mentorregistinfo.registId, mentorregistinfo.memberId, mentorregistinfo.applyDate, mentorapply.state, mentorapply.confirmDate FROM mentorapply "
				+ "LEFT JOIN mentorregistinfo "
				+ "ON mentorapply.registId = mentorregistinfo.registId";
		
		try {
			return template.query(SQL, new RowMapper<Map<String, Object>>() {

				@Override
				public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
					Map<String, Object> applyData = new HashMap<String, Object>();
					applyData.put("registId", rs.getString(1));
					applyData.put("memberId", rs.getString(2));
					applyData.put("applyDate", rs.getTimestamp(3));
					applyData.put("state", rs.getString(4));
					if(rs.getTimestamp(5) != null) {
						applyData.put("confirmDate", rs.getTimestamp(5));
					} else {
						applyData.put("confirmDate", null);
					}
					return applyData;
				}
				
			});
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public List<Map<String, Object>> getMentorApplyList(String state) {
		String SQL = "SELECT mentorregistinfo.registId, mentorregistinfo.memberId, mentorregistinfo.applyDate, mentorapply.state, mentorapply.confirmDate FROM mentorapply "
				+ "LEFT JOIN mentorregistinfo "
				+ "ON mentorapply.registId = mentorregistinfo.registId ";
		
		if(state.equals("Confirm")) {
			SQL = SQL + "WHERE state = 'Accept' or state = 'Refuse'";
		} else if(state.equals("Wait")) {
			SQL = SQL + "WHERE state = 'Wait'";			
		}
		
		try {
			return template.query(SQL, new RowMapper<Map<String, Object>>() {

				@Override
				public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
					Map<String, Object> applyData = new HashMap<String, Object>();
					applyData.put("registId", rs.getString(1));
					applyData.put("memberId", rs.getString(2));
					applyData.put("applyDate", rs.getTimestamp(3));
					applyData.put("state", rs.getString(4));
					if(rs.getTimestamp(5) != null) {
						applyData.put("confirmDate", rs.getTimestamp(5));
					} else {
						applyData.put("confirmDate", null);
					}
					return applyData;
				}
				
			});
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	
	// 멘토 신청 회원의 정보
	@Override
	public MentorRegistInfo getMentorApplyByMemberId(String memberId) {
		String SQL = "SELECT * FROM mentorregistinfo WHERE memberId = ?";
		try {
			return template.query(SQL, new BeanPropertyRowMapper<MentorRegistInfo>(MentorRegistInfo.class), memberId).get(0);
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	// 특정 멤버의 멘토 신청의 상태
	@Override
	public Map<String, Object> getMentorApplyState(String memberId) {
		String SQL;
		
		try {
			SQL = "SELECT * FROM mentorapply WHERE memberId = ? and state = 'Wait'";
			return template.queryForMap(SQL, memberId);
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	// 멤버 리스트
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
	
	// 멘토 신청 승인
	@Override
	public void mentorRegist(String memberId, String registId) {
		String SQL;
		
		try {
			SQL = "INSERT INTO mentor VALUES(?, ?, ?)";
			template.update(SQL, util.createId("mentor"), memberId, LocalDateTime.now());
			
			SQL = "UPDATE mentorapply SET state = 'Accept', confirmDate = ?  WHERE memberId = ? and registId = ?";
			template.update(SQL, LocalDateTime.now() , memberId, registId);
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
	
	// 멘토 신청 거절
	@Override
	public void mentorRefuse(String memberId, String registId) {
		String SQL;
		
		try {
			SQL = "UPDATE mentorapply SET state = 'Refuse', confirmDate = ? WHERE memberId = ? and registId = ?";
			template.update(SQL, LocalDateTime.now(), memberId, registId);
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
	}
	
}
