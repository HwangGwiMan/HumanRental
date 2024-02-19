package com.springmvc.domain.alarm;

import java.time.LocalDateTime;

public abstract class Alarm {
	private String alarmId;
	private String sendMemberId;
	private String receiveMemberId;
	private LocalDateTime date;
	protected String content;
	public String getAlarmId() {
		return alarmId;
	}
	public void setAlarmId(String alarmId) {
		this.alarmId = alarmId;
	}
	public String getSendMemberId() {
		return sendMemberId;
	}
	public void setSendMemberId(String sendMemberId) {
		this.sendMemberId = sendMemberId;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getReceiveMemberId() {
		return receiveMemberId;
	}
	public void setReceiveMemberId(String receiveMemberId) {
		this.receiveMemberId = receiveMemberId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	abstract public void createContent();
	abstract public void createDate();
}
