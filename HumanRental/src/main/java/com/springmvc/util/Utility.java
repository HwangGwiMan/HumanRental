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
	
	public String sortSQL(String sort, String sortTarget) {
		String orderSQL = new String();
		
		if(sortTarget.equals("거래 유형")) {
			orderSQL = "ORDER BY boardId ";
		} else if(sortTarget.equals("재능명")) {
			orderSQL = "ORDER BY title ";
		} else if(sortTarget.equals("멘토 ID")) {
			orderSQL = "ORDER BY memberId ";
		} else if(sortTarget.equals("멘티 ID")) {
			orderSQL = "ORDER BY applicantMemberId ";
		} else if(sortTarget.equals("일정")) {
			orderSQL = "ORDER BY reservationDate ";
		} else if(sortTarget.equals("상태")) {
			orderSQL = "ORDER BY approve ";
		} else if(sortTarget.equals("예약 매칭 날짜")) {
			orderSQL = "ORDER BY signDate ";
		}
		
		if(sortTarget.equals("신고자 ID")) {
			orderSQL = "ORDER BY reporterId ";
		} else if(sortTarget.equals("신고 유형")) {
			orderSQL = "ORDER BY target ";
		} else if(sortTarget.equals("신고 대상 ID")) {
			orderSQL = "ORDER BY targetId ";
		} else if(sortTarget.equals("신고 내용")) {
			orderSQL = "ORDER BY type ";
		} else if(sortTarget.equals("처리 상태")) {
			orderSQL = "ORDER BY state ";
		} else if(sortTarget.equals("신고 날짜")) {
			orderSQL = "ORDER BY createDate ";
		}
				
		return orderSQL + sortType(sort);
	}
	
	/*
	 * 0 -> 정렬 안함
	 * 1 -> 오름차순
	 * 2 -> 내림차순
	 */	
	public String sortType(String sort) {
		
		if(sort.equals("1")) {
			return "ASC";
		} else if(sort.equals("2")) {
			return "DESC";
		} else {
			return "";
		}
	}
}
