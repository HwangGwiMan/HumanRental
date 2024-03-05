package com.springmvc.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
		
		String sql = "insert into Reservation values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		template.update(sql, reservation.getReservationId(), reservation.getBoardId(), reservation.getTitle(), 
				reservation.getMenteeId(), reservation.getMentorId(), reservation.getReservationdate(), reservation.getReservationcontent(), 
				reservation.getApprove(), reservation.getSigndate(), reservation.getMemberId(), reservation.getApplicantMemberId(), 
				reservation.getRegist_day(), reservation.getCompletionDate());
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
	public List<Reservation> getAllReservation() {
		String SQL;
		
		try {
			SQL = "SELECT * FROM reservation";
			return template.query(SQL, new BeanPropertyRowMapper<Reservation>(Reservation.class));
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public List<Reservation> getAllReservation(String state) {
		String SQL = "SELECT * FROM reservation ";
		
		if(state.equals("buy")) {
			SQL += "WHERE boardId like '%buy%'";
		} else if(state.equals("sell")) {
			SQL += "WHERE boardId like '%sell%'";
		}

		try {
			return template.query(SQL, new BeanPropertyRowMapper<Reservation>(Reservation.class));
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public Reservation GetReservationInfo(String reservationId) {
		String sql = "select * from Reservation where reservationId = ?";
		Reservation reservation = template.query(sql, new ReservationRowMapper(), reservationId).get(0);
		return reservation;
	}
	
	@Override
	public void ReservationApproval(String reservationId, String approval) {
		System.out.println(reservationId);
		System.out.println(approval);
		String sql;
		if(approval.equals("yes")) {
			sql = "UPDATE reservation SET approve = ?, signdate = ? WHERE reservationId = ?";
			template.update(sql, "승인", LocalDateTime.now(), reservationId);
		}
		else if(approval.equals("no")) {
			sql = "UPDATE reservation SET approve = ? WHERE reservationId = ?";
			template.update(sql, "거절", reservationId);
		}
		else if(approval.equals("rentalyes")) {
			sql = "UPDATE reservation SET approve = ?, completionDate = ? WHERE reservationId = ?";
			template.update(sql, "렌탈완료", LocalDateTime.now(), reservationId);
		}
		else if(approval.equals("rentalno")) {
			sql = "UPDATE reservation SET approve = ? WHERE reservationId = ?";
			template.update(sql, "렌탈실패", reservationId);
		}
//		else if(approval.equals("review")) {
//			sql = "UPDATE reservation SET approve = ? WHERE reservationId = ?";
//			template.update(sql, "후기작성", reservationId);
//		}
		
	}
}