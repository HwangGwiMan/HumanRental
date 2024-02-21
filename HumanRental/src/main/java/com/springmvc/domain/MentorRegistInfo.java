package com.springmvc.domain;

import java.time.LocalDateTime;

public class MentorRegistInfo {
	private String registId;
	private String memberId;
	private String specialty;
	private String location;
	private String reason;
	private String etc;
	private LocalDateTime applyDate;
	public LocalDateTime getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(LocalDateTime applyDate) {
		this.applyDate = applyDate;
	}
	public String getRegistId() {
		return registId;
	}
	public void setRegistId(String registId) {
		this.registId = registId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	
}