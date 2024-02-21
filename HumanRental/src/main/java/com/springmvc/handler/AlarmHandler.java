package com.springmvc.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.springmvc.service.AlarmService;

@Component
public class AlarmHandler extends TextWebSocketHandler{

	@Autowired
	AlarmService alarmService;
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String memberId = (String) session.getAttributes().get("user");
		String alarmId = message.getPayload();
		
		alarmService.deleteAlarm(memberId, alarmId);
		session.sendMessage(new TextMessage(alarmId));
	}
}
