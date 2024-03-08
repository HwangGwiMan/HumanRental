package com.springmvc.service;

import java.util.List;
import java.util.Map;

import com.springmvc.domain.Alarm;
import com.springmvc.domain.Reservation;

public interface AlarmService {
	public void createMentoApplyAlarm(String memberId, String string);
	public void createMentoApplyResultAlarm(String memberId, String result);
	public List<Alarm> selectAlarm(String memberId);
	public void deleteAlarm(String memberId, String alarmId);
	void createWarningAlarm(Map<String, Object> data);
	void createReservationApplyAlarm(Reservation reservation);
	void createReservationConfirmAlarm(String reservationId, String approval);

}
