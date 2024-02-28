package com.springmvc.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reservation {
	private String reservationId;
	private String boardId;
	private String title;
	private String menteeId;
	private String mentorId;
	private LocalDate reservationdate;
	private String reservationcontent;
	private String approve;
	private LocalDateTime signdate;
	private String memberId;
	private String applicantMemberId;
	private String menteeNickname;
	private String mentorNickname;
	private LocalDateTime regist_day;
	
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
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
	
	public String getApprove() {
		return approve;
	}
	public void setApprove(String approve) {
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
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getApplicantMemberId() {
		return applicantMemberId;
	}
	public void setApplicantMemberId(String applicantMemberId) {
		this.applicantMemberId = applicantMemberId;
	}
	public String getMenteeNickname() {
		return menteeNickname;
	}
	public void setMenteeNickname(String menteeNickname) {
		this.menteeNickname = menteeNickname;
	}
	public String getMentorNickname() {
		return mentorNickname;
	}
	public void setMentorNickname(String mentorNickname) {
		this.mentorNickname = mentorNickname;
	}
	public LocalDateTime getRegist_day() {
		return regist_day;
	}
	public void setRegist_day(LocalDateTime regist_day) {
		this.regist_day = regist_day;
	}
	
	
}
