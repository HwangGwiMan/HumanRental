package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.springmvc.domain.Board;
import com.springmvc.domain.Buying;
import com.springmvc.domain.Reservation;
import com.springmvc.domain.Selling;
import com.springmvc.util.Utility;

@Repository
public class ReservationRepositoryImpl implements ReservationRepository{
	
	Utility util = new Utility();
	
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
	public List<Reservation> getAllReservation(String sort, String sortTarget) {
		String SQL = "SELECT * FROM reservation ";
		
		if(!(sort.equals("none") || sort.equals("0"))) {
			SQL += util.sortSQL(sort, sortTarget);
		}
		
		try {
//			return template.query(SQL, new BeanPropertyRowMapper<Reservation>(Reservation.class));
			
			return template.query(SQL, new RowMapper<Reservation>() {

				@Override
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
					
					if(reservation.getBoardId().contains("buy")) {
						reservation.setMemberId(rs.getString(11));
						reservation.setApplicantMemberId(rs.getString(10));
					} else if(reservation.getBoardId().contains("sell")) {
						reservation.setMemberId(rs.getString(10));
						reservation.setApplicantMemberId(rs.getString(11));
					}
					
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
				
			});
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public List<Reservation> getAllReservation(String state, String sort, String sortTarget) {
		String SQL = "SELECT * FROM reservation ";
		
		if(state.equals("buy")) {
			SQL += "WHERE boardId like '%buy%'";
		} else if(state.equals("sell")) {
			SQL += "WHERE boardId like '%sell%'";
		}
		
		if(!(sort.equals("none") || sort.equals("0"))) {
			SQL += util.sortSQL(sort, sortTarget);
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
		
	}
}