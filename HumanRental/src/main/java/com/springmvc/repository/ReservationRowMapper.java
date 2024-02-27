package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.Board;
import com.springmvc.domain.Reservation;

public class ReservationRowMapper implements RowMapper<Reservation> {

	public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
		Reservation reservation = new Reservation();
		reservation.setReservationId(rs.getString(1));
		reservation.setType(rs.getString(2));
		reservation.setTitle(rs.getString(3));
		reservation.setMenteeId(rs.getString(4));
		reservation.setMentorId(rs.getString(5));
		reservation.setReservationdate(rs.getDate(6).toLocalDate());
		reservation.setReservationcontent(rs.getString(7));
		reservation.setApprove(rs.getString(8));
		if(rs.getTimestamp(9)==null)
		{
			reservation.setSigndate(null);
		}
		else {
			reservation.setSigndate(rs.getTimestamp(9).toLocalDateTime());
		}
		return reservation;
	}
}
