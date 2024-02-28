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
		
		String sql = "insert into Reservation values(?,?,?,?,?,?,?,?,?,?,?)";
		template.update(sql, reservation.getReservationId(), reservation.getBoardId(), reservation.getTitle(), 
				reservation.getMenteeId(), reservation.getMentorId(), reservation.getReservationdate(), reservation.getReservationcontent(), 
				reservation.getApprove(), reservation.getSigndate(), reservation.getMemberId(), reservation.getApplicantMemberId());
	}

	@Override
	public List<Reservation> getReservationListById(String menteeid, String mentorid) {
		
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		String sql = "select * from Reservation where menteeId = ? or mentorId = ?";
        list = (ArrayList<Reservation>)template.query(sql, new ReservationRowMapper(), menteeid, mentorid);
        return list;
	}

	@Override
	public List<Reservation> getReservationApprovalListById(String memberId) {
		
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		String sql = "select * from Reservation where memberId = ? order by reservationdate";
        try {
    		list = (ArrayList<Reservation>)template.query(sql, new ReservationRowMapper(), memberId);
        }
        catch(Exception e) {
        	return null;
        }
        return list;
	}
	
	@Override
	public Reservation GetReservationInfo(String reservationId) {
		String sql = "select * from Reservation where reservationId = ?";
		Reservation reservation = template.query(sql, new ReservationRowMapper(), reservationId).get(0);
		return reservation;
	}
}