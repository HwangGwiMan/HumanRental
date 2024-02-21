package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Alarm;

public interface AlarmService {
	public void createMentoApplyAlarm(String memberId);
	public void createMentoApplyResultAlarm(String memberId, String result);
	public List<Alarm> selectAlarm(String memberId);
	public void deleteAlarm(String memberId, String alarmId);
}
