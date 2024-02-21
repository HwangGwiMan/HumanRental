package com.springmvc.interceptor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.springmvc.domain.Alarm;
import com.springmvc.service.AlarmService;

public class AlarmInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	AlarmService alarmService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
		
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("user");
		
		if(modelAndView != null && memberId != null) {
			List<String> alarmTime = new ArrayList<String>();
			List<String> durations = new ArrayList<String>(); 
			List<Alarm> alarmList = alarmService.selectAlarm(memberId);
			for(Alarm alarm : alarmList) {
				long time = Duration.between(alarm.getDate(), LocalDateTime.now()).getSeconds();
				if(time >= 86400) {
					durations.add(String.valueOf(time / 86400) + "일 전");
				} else if(time >= 3600) {
					durations.add(String.valueOf(time / 3600) + "시간 전");
				} else if(time >= 60) {
					durations.add(String.valueOf(time / 60)+ "분 전");
				} else {
					durations.add(String.valueOf(time) + "초 전");
				}
				alarmTime.add(alarm.getDate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")));
			}
			
			modelAndView.addObject("alarmList", alarmList);
			modelAndView.addObject("duration", durations);
			modelAndView.addObject("alarmTime", alarmTime);
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
	
}
