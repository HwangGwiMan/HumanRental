package com.springmvc.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.TimeZone;

public class Utility {
	
	// ID 생성
	public String createId(String target) {
		// 현재 시간 long로 변환
		long number = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(); 
		return target + "_" + number;
	}
	
	// 출력 날짜 포메팅
	public String outputFormatting(Timestamp date) {
		
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getDefault());

		return dateFormat.format(date);
	}
}
