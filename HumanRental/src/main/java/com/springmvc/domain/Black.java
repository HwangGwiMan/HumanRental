package com.springmvc.domain;

import java.time.LocalDateTime;

public class Black {
	private String blackId;
	private String memberId;
	private Object registDate;
	public String getBlackId() {
		return blackId;
	}
	public void setBlackId(String blackId) {
		this.blackId = blackId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Object getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Object registDate) {
		this.registDate = registDate;
	}
}
