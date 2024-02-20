package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.alarm.Alarm;

public interface AlarmRepository {
	public void createMentoApplyAlarm(String memberId);
	public List<Alarm> selectAlarm(String memberId);
	public void deleteAlarm(String memberId, String alarmId);
}
