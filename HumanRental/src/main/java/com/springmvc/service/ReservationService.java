package com.springmvc.service;

import com.springmvc.domain.Buying;
import com.springmvc.domain.Reservation;

public interface ReservationService {
	public Reservation ReservationCreate(String buyingId, String date, String content, String memberId);
//	public Reservation getReservation(Model model);
}
