package com.springmvc.repository;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.springmvc.domain.Board;
import com.springmvc.domain.Buying;
import com.springmvc.domain.Reservation;
import com.springmvc.domain.Selling;

@Repository
public class ReservationRepositoryImpl implements ReservationRepository{
	
	// JDBC
	private JdbcTemplate template;

	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void ReservationCreate(Reservation reservation) {
		
		String sql = "insert into Reservation values(?,?,?,?,?,?,?,?,?)";
		template.update(sql, reservation.getReservationId(), reservation.getType(), reservation.getTitle(), 
				reservation.getMenteeId(), reservation.getMentorId(), reservation.getReservationdate(), reservation.getReservationcontent(), 
				reservation.getApprove(), reservation.getSigndate());
	}

	@Override
	public List<Reservation> getReservationListById(String menteeid, String mentorid) {
		
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		String sql = "select * from Reservation where menteeId = ? or mentorId = ?";
        list = (ArrayList<Reservation>)template.query(sql, new ReservationRowMapper(), menteeid, mentorid);
        return list;
	}
	
	
	
}