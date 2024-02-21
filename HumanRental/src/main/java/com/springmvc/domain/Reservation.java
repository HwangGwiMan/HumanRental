package com.springmvc.domain;

import java.time.LocalDateTime;

public class Reservation {
	private String reservationId;
	private String title;
	private String menteeId;
	private String mentorId;
	private LocalDateTime signDate;
	
	public String getReservationId() {
		return reservationId;
	}
	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMenteeId() {
		return menteeId;
	}
	public void setMenteeId(String menteeId) {
		this.menteeId = menteeId;
	}
	public String getMentorId() {
		return mentorId;
	}
	public void setMentorId(String mentorId) {
		this.mentorId = mentorId;
	}
	public LocalDateTime getSignDate() {
		return signDate;
	}
	public void setSignDate(LocalDateTime signDate) {
		this.signDate = signDate;
	}
	
	
	
}
