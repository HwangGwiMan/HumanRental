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
		
		System.out.println("getReservationId="+reservation.getReservationId());
		System.out.println("getType="+reservation.getType());
		System.out.println("getTitle="+reservation.getTitle());
		System.out.println("getMenteeId="+reservation.getMenteeId());
		System.out.println("getMentorId="+reservation.getMentorId());
		System.out.println("getReservationdate="+reservation.getReservationdate());
		System.out.println("getReservationcontent="+reservation.getReservationcontent());
		System.out.println("isApprove="+reservation.isApprove());
		System.out.println("getSigndate="+reservation.getSigndate());
		String sql = "insert into Reservation values(?,?,?,?,?,?,?,?,?)";
		template.update(sql, reservation.getReservationId(), reservation.getType(), reservation.getTitle(), 
				reservation.getMenteeId(), reservation.getMentorId(), reservation.getReservationdate(), reservation.getReservationcontent(), 
				reservation.isApprove(), reservation.getSigndate());
	}
	
	
	
}