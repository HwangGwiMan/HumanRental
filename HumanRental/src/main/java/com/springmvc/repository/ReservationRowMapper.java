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
		reservation.setBoardId(rs.getString(2));
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
		reservation.setMemberId(rs.getString(10));
		reservation.setApplicantMemberId(rs.getString(11));
		reservation.setRegist_day(rs.getTimestamp(12).toLocalDateTime());
		if(rs.getTimestamp(13)==null)
		{
			reservation.setCompletionDate(null);
		}
		else {
			reservation.setCompletionDate(rs.getTimestamp(13).toLocalDateTime());
		}
		return reservation;
	}
}
