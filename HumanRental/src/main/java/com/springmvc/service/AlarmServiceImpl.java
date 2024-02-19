package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.alarm.Alarm;
import com.springmvc.repository.AlarmRepository;

@Service
public class AlarmServiceImpl implements AlarmService{
	
	@Autowired
	AlarmRepository alarmRepository;
	
	@Override
	public void createMentoApplyAlarm(String memberId) {
		alarmRepository.createMentoApplyAlarm(memberId);
	}

	@Override
	public List<Alarm> selectAlarm(String memberId) {
		return alarmRepository.selectAlarm(memberId);
	}
	
}
