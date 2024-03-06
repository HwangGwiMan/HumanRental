package com.springmvc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.springmvc.domain.Buying;
import com.springmvc.domain.Mentee;
import com.springmvc.domain.Mentor;
import com.springmvc.domain.Reservation;
import com.springmvc.domain.Selling;
import com.springmvc.repository.BuyingRepository;
import com.springmvc.repository.MemberRepository;
import com.springmvc.repository.MenteeRepository;
import com.springmvc.repository.MentorRepository;
import com.springmvc.repository.ReservationRepository;
import com.springmvc.repository.SellingRepository;
import com.springmvc.util.Utility;

@Repository
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	ReservationRepository reservationrepository;
	
	@Autowired
	BuyingRepository buyingrepository;
	
	@Autowired
	SellingRepository sellingrepository;
	
	@Autowired
	MenteeRepository menteerepository;
	
	@Autowired
	MentorRepository mentorrepository;
	
	@Autowired
	MemberRepository memberrepository;

	Utility util = new Utility();

	@Override
	public Reservation BuyingReservationCreate(String buyingId, String date, String content, String memberId, Model model) {
		
		Buying buying = buyingrepository.BuyingDetailbyId(buyingId);
		System.out.println("buying.getMemberId()"+buying.getMemberId());
		Mentee mentee = menteerepository.getInformation(buying.getMemberId());
		System.out.println("BuyingReservationCreate여긴 오니?");
		Mentor mentor = mentorrepository.getMentor(memberId);
		
		Reservation reservation = new Reservation();
		reservation.setReservationId(util.createId("Reservation"));
		reservation.setBoardId(buying.getBuyingId());
		reservation.setTitle(buying.getTitle());
		reservation.setMenteeId(mentee.getMenteeId());
		reservation.setMentorId(mentor.getMentorId());
		reservation.setReservationdate(LocalDate.parse(date));
		reservation.setReservationcontent(content);
		reservation.setApprove("대기");
		reservation.setMemberId(buying.getMemberId());
		reservation.setApplicantMemberId(memberId);
		reservation.setRegist_day(LocalDateTime.now());
		
		reservationrepository.ReservationCreate(reservation);
		
		String menteeNickname = memberrepository.getMember(mentee.getMemberId()).getNickName();
		String mentorNickname = memberrepository.getMember(mentor.getMemberId()).getNickName();
		model.addAttribute("menteeNickname",menteeNickname);
		model.addAttribute("mentorNickname",mentorNickname);
		
		return reservation;
	}

	@Override
	public Reservation SellingReservationCreate(String sellingId, String date, String content, String memberId, Model model) {
		
		Selling selling = sellingrepository.SellingDetailbyId(sellingId);
		Mentee mentee = menteerepository.getInformation(memberId);
		Mentor mentor = mentorrepository.getMentor(selling.getMemberId());
		
		Reservation reservation = new Reservation();
		reservation.setReservationId(util.createId("Reservation"));
		reservation.setBoardId(selling.getSellingId());
		reservation.setTitle(selling.getTitle());
		reservation.setMenteeId(mentee.getMenteeId());
		reservation.setMentorId(mentor.getMentorId());
		reservation.setReservationdate(LocalDate.parse(date));
		reservation.setReservationcontent(content);
		reservation.setApprove("대기");
		reservation.setMemberId(selling.getMemberId());
		reservation.setApplicantMemberId(memberId);
		reservation.setRegist_day(LocalDateTime.now());
		
		reservationrepository.ReservationCreate(reservation);
		
		String menteeNickname = memberrepository.getMember(mentee.getMemberId()).getNickName();
		String mentorNickname = memberrepository.getMember(mentor.getMemberId()).getNickName();
		model.addAttribute("menteeNickname",menteeNickname);
		model.addAttribute("mentorNickname",mentorNickname);
		
		return reservation;
	}

	@Override
	public List<Reservation> getReservationListById(String memberId, Model model) {
		
		String menteeid;
		String mentorid;
		String menteeNickname;
		String mentorNickname;
		
		try {
			menteeid = menteerepository.getInformation(memberId).getMenteeId();
		}
		catch(Exception e){
			menteeid = null;
		}
		
		try {
			mentorid = mentorrepository.getMentor(memberId).getMentorId();
		}
		catch(Exception e){
			mentorid = null;
		}
		
		List<Reservation> list = reservationrepository.getReservationListById(menteeid, mentorid);
		
		if(list != null) {
			for(Reservation a : list) {
				menteeNickname = memberrepository.getMember(menteerepository.getMentee2(a.getMenteeId()).getMemberId()).getNickName();
				mentorNickname = memberrepository.getMember(mentorrepository.getMentor2(a.getMentorId()).getMemberId()).getNickName();
				a.setMenteeNickname(menteeNickname);
				a.setMentorNickname(mentorNickname);
			}
		}
		model.addAttribute("reservationlist", list);
		
		return null;
	}
	
	@Override
	public List<Reservation> getReservationApprovalListById(String memberId, Model model) {

		String menteeNickname;
		String mentorNickname;
		
		List<Reservation> list = reservationrepository.getReservationApprovalListById(memberId);
		if(list != null) {
			for(Reservation a : list) {
				if(a.getBoardId().contains("buy")) {
					menteeNickname = memberrepository.getMember(a.getApplicantMemberId()).getNickName();
					a.setMenteeNickname(menteeNickname);
				}
				else {
					mentorNickname = memberrepository.getMember(a.getApplicantMemberId()).getNickName();
					a.setMentorNickname(mentorNickname);
				}
			}
		}
		model.addAttribute("reservationlist", list);
		
		return null;
	}
	
	@Override
	public List<Reservation> getMonitorReservationStatus(String sort, String sortTarget) {
		return reservationrepository.getAllReservation(sort, sortTarget);
	}
	

	@Override
	public List<Reservation> getMonitorReservationStatus(String state, String sort, String sortTarget) {
		return reservationrepository.getAllReservation(state, sort, sortTarget);
	}

	@Override
	public void GetReservationInfo(String reservationId, Model model) {
		
		String menteeNickname;
		String mentorNickname;
		
		Reservation reservation = reservationrepository.GetReservationInfo(reservationId);
		
		if(reservation.getBoardId().contains("buy")) {
			menteeNickname = memberrepository.getMember(reservation.getApplicantMemberId()).getNickName();
			mentorNickname = memberrepository.getMember(reservation.getMemberId()).getNickName();
			reservation.setMenteeNickname(menteeNickname);
			reservation.setMentorNickname(mentorNickname);
		}
		else {
			menteeNickname = memberrepository.getMember(reservation.getMemberId()).getNickName();
			mentorNickname = memberrepository.getMember(reservation.getApplicantMemberId()).getNickName();
			reservation.setMenteeNickname(menteeNickname);
			reservation.setMentorNickname(mentorNickname);
		}
		
		model.addAttribute("reservation", reservation);
	}

	@Override
	public void ReservationApproval(String reservationId, String approval) {
		reservationrepository.ReservationApproval(reservationId, approval);
		
	}
	
	
}