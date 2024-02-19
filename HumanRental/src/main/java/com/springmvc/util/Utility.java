package com.springmvc.util;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Utility {
	
	// ID 생성
	public String createId(String target) {
		// 현재 시간 long로 변환
		long number = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(); 
		return target + "_" + number;
	}
}
