package com.springmvc.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reservation {
	private String reservationId;
	private String type;
	private String title;
	private String menteeId;
	private String mentorId;
	private LocalDate reservationdate;
	private String reservationcontent;
	private boolean approve;
	private LocalDateTime signdate;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
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
	public LocalDate getReservationdate() {
		return reservationdate;
	}
	public void setReservationdate(LocalDate reservationdate) {
		this.reservationdate = reservationdate;
	}
	public boolean isApprove() {
		return approve;
	}
	public void setApprove(boolean approve) {
		this.approve = approve;
	}
	public LocalDateTime getSigndate() {
		return signdate;
	}
	public void setSigndate(LocalDateTime signdate) {
		this.signdate = signdate;
	}
	public String getReservationcontent() {
		return reservationcontent;
	}
	public void setReservationcontent(String reservationcontent) {
		this.reservationcontent = reservationcontent;
	}
	
	
}
