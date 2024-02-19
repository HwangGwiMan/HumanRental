package com.springmvc.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.springmvc.domain.alarm.Alarm;
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
			List<Alarm> alarmList = alarmService.selectAlarm(memberId);
			modelAndView.addObject("alarmList", alarmList);
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
	
}
