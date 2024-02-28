package com.springmvc.repository;

import java.util.List;

import org.springframework.ui.Model;

import com.springmvc.domain.Buying;
import com.springmvc.domain.Reservation;

public interface ReservationRepository {
	public void ReservationCreate(Reservation reservation);
	public List<Reservation> getReservationListById(String menteeid, String mentorid);
	public List<Reservation> getReservationApprovalListById(String memberId);
	public Reservation GetReservationInfo(String reservationId);
}
