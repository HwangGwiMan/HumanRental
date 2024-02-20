package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.MentorRegistInfo;
import com.springmvc.domain.alarm.Alarm;
import com.springmvc.domain.alarm.MentoApplyAlarm;
import com.springmvc.util.Utility;

@Repository
public class AlarmRepositoryImpl implements AlarmRepository {
	
	Utility util = new Utility();
	
	// JDBC
	private JdbcTemplate template;

	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	public void createMentoApplyAlarm(String memberId) {
		Alarm alarm = new MentoApplyAlarm(memberId);
		String SQL;
		
		try {
			SQL = "INSERT INTO alarm VALUES(?, ?, ?, ?, ?)";
			template.update(SQL, util.createId("mentoApplyAlarm"),alarm.getSendMemberId(), alarm.getReceiveMemberId(), alarm.getDate(), alarm.getContent());
		} catch (EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
	
	public List<Alarm> selectAlarm(String memberId) {
		String SQL;
		
		List<Alarm> alarmList = null;
		
		try {
			SQL = "SELECT * FROM alarm WHERE memberId = ?";
			alarmList = template.query(SQL, new RowMapper<Alarm>() {

				@Override
				public Alarm mapRow(ResultSet rs, int rowNum) throws SQLException {
					Alarm alarm = new MentoApplyAlarm();
					alarm.setAlarmId(rs.getString(1));
					alarm.setReceiveMemberId(rs.getString(2));
//					alarm.setDate(new java.sql.Timestamp(rs.getDate(3).getTime()).toLocalDateTime());
					alarm.setDate(rs.getTimestamp(3).toLocalDateTime());
					alarm.setContent(rs.getString(4));
					return alarm;
				}
			}, memberId);
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		return alarmList;
	}

	@Override
	public void deleteAlarm(String memberId, String alarmId) {
		String SQL;
		
		try {
			SQL = "DELETE FROM alarm WHERE memberId = ? and alarmId = ?";
			template.update(SQL, memberId, alarmId);
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
}
