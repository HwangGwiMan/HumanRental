package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.Alarm;

public interface AlarmRepository {
	public void createMentoApplyAlarm(String memberId);
	public void createMentoApplyResultAlarm(String memberId, String result);
	public List<Alarm> selectAlarm(String memberId);
	public void deleteAlarm(String memberId, String alarmId);
}
