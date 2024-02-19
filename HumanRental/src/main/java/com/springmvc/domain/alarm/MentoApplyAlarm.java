package com.springmvc.domain.alarm;

import java.time.LocalDateTime;

public class MentoApplyAlarm extends Alarm {
	
	private String content;
	
	public MentoApplyAlarm(String memberId) {
		super.setSendMemberId(memberId);
		this.createContent();
		this.createDate();
		super.setReceiveMemberId("admin");
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public void createContent() {
		this.content = super.getSendMemberId() + "님의 멘토 신청입니다.";
	}
	@Override
	public void createDate() {
		super.setDate(LocalDateTime.now());
	}
}
