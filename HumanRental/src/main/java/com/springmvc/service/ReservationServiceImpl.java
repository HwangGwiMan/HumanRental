package com.springmvc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.springmvc.domain.Board;
import com.springmvc.domain.Reservation;
import com.springmvc.domain.Buying;
import com.springmvc.repository.ReservationRepository;
import com.springmvc.repository.BuyingRepository;
import com.springmvc.util.Utility;

@Repository
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	ReservationRepository reservationrepository;
	
	@Autowired
	BuyingRepository buyingrepository;
	
	Utility util = new Utility();

	@Override
	public Reservation ReservationCreate(String buyingId, String date, String content, String memberId) {
		
		// 추후에 멘티, 멘토 아이디로 변경해야함
		
		Buying buying = buyingrepository.BuyingDetailbyId(buyingId);
		
		Reservation reservation = new Reservation();
		reservation.setReservationId(util.createId("Reservation"));
		reservation.setType("buy");
		reservation.setTitle(buying.getTitle());
		reservation.setMenteeId(buying.getMemberId());
		reservation.setMentorId(memberId);
		reservation.setReservationdate(LocalDate.parse(date));
		reservation.setReservationcontent(content);
		reservation.setApprove(false);
		
		reservationrepository.ReservationCreate(reservation);
		
		return reservation;
	}
	
	
}