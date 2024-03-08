package com.springmvc.domain;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Alarm {
	private String alarmId;
	private String sendMemberId;
	private String receiveMemberId;
	private Object date;
	private String content;
	private String linkId;
	public Alarm() {
		this.setDate(LocalDateTime.now(ZoneId.of("Asia/Seoul")));
	}
	
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
	public Object getDate() {
		return date;
	}
	public void setDate(Object date) {
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
	public String getLinkId() {
		return linkId;
	}
	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}
}
