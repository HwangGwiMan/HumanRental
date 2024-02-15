package com.springmvc.domain;

public class MentorRegistInfo {
	private String registrId;
	private String memberId;
	private String specialty[];
	private String location[];
	private String reason[];
	private String etc;
	public String getRegistrId() {
		return registrId;
	}
	public void setRegistrId(String registrId) {
		this.registrId = registrId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String[] getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String[] specialty) {
		this.specialty = specialty;
	}
	public String[] getLocation() {
		return location;
	}
	public void setLocation(String[] location) {
		this.location = location;
	}
	public String[] getReason() {
		return reason;
	}
	public void setReason(String[] reason) {
		this.reason = reason;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	
}