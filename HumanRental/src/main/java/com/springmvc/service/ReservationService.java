package com.springmvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.springmvc.domain.Buying;
import com.springmvc.domain.Reservation;

public interface ReservationService {
	public Reservation BuyingReservationCreate(String buyingId, String date, String content, String memberId, Model model);
	public Reservation SellingReservationCreate(String sellingId, String date, String content, String memberId, Model model);
	public List<Reservation> getReservationListById(String memberId, Model model);
	public List<Reservation> getReservationApprovalListById(String memberId, Model model);
	public List<Reservation> getMonitorReservationStatus();
	public Reservation GetReservationInfo(String reservationId, Model model);
	public void ReservationApproval(String reservationId, String approval);
}
