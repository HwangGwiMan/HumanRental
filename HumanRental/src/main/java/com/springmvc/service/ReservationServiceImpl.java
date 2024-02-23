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
import com.springmvc.domain.Mentee;
import com.springmvc.domain.Mentor;
import com.springmvc.repository.ReservationRepository;
import com.springmvc.repository.BuyingRepository;
import com.springmvc.repository.MemberRepository;
import com.springmvc.repository.MenteeRepository;
import com.springmvc.repository.MentorRepository;
import com.springmvc.util.Utility;

@Repository
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	ReservationRepository reservationrepository;
	
	@Autowired
	BuyingRepository buyingrepository;
	
	@Autowired
	MenteeRepository menteerepository;
	
	@Autowired
	MentorRepository mentorrepository;
	
	@Autowired
	MemberRepository memberrepository;
	
	Utility util = new Utility();

	@Override
	public Reservation ReservationCreate(String buyingId, String date, String content, String memberId, Model model) {
		
		Buying buying = buyingrepository.BuyingDetailbyId(buyingId);
		Mentee mentee=menteerepository.getInformation(buying.getMemberId());
		Mentor mentor=mentorrepository.getMentor(memberId);
		
		Reservation reservation = new Reservation();
		reservation.setReservationId(util.createId("Reservation"));
		reservation.setType("buy");
		reservation.setTitle(buying.getTitle());
		reservation.setMenteeId(mentee.getMenteeId());
		reservation.setMentorId(mentor.getMentorId());
		reservation.setReservationdate(LocalDate.parse(date));
		reservation.setReservationcontent(content);
		reservation.setApprove(false);
		
		reservationrepository.ReservationCreate(reservation);
		
		String menteeNickname = memberrepository.getMember(mentee.getMemberId()).getNickName();
		String mentorNickname = memberrepository.getMember(mentor.getMemberId()).getNickName();
		model.addAttribute("menteeNickname",menteeNickname);
		model.addAttribute("mentorNickname",mentorNickname);
		
		return reservation;
	}
	
	
}