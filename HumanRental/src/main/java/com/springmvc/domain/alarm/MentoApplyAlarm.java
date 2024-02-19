package com.springmvc.domain.alarm;

import java.time.LocalDateTime;

public class MentoApplyAlarm extends Alarm {
	
	public MentoApplyAlarm() {
		
	}

	public MentoApplyAlarm(String memberId) {
		super.setSendMemberId(memberId);
		this.createContent();
		this.createDate();
		super.setReceiveMemberId("admin");
	}
	
	@Override
	public void createContent() {
		super.content = super.getSendMemberId() + "님의 멘토 신청입니다.";
	}
	@Override
	public void createDate() {
		super.setDate(LocalDateTime.now());
	}
}
