package com.springmvc.domain;

import org.springframework.web.multipart.MultipartFile;

public class MentorProfile {
	
	private String mentorId;
	private String memberId;
	private String introduction;
	private String category;
	private String certification;
	private String filename1;
	private String filename2;
	private String filename3;
	private int starRate;
	private int starCount;
	
	public String getMentorId() {
		return mentorId;
	}
	public void setMentorId(String mentorId) {
		this.mentorId = mentorId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCertification() {
		return certification;
	}
	public void setCertification(String certification) {
		this.certification = certification;
	}
	public String getFilename1() {
		return filename1;
	}
	public void setFilename1(String filename1) {
		this.filename1 = filename1;
	}
	public String getFilename2() {
		return filename2;
	}
	public void setFilename2(String filename2) {
		this.filename2 = filename2;
	}
	public String getFilename3() {
		return filename3;
	}
	public void setFilename3(String filename3) {
		this.filename3 = filename3;
	}
	public int getStarRate() {
		return starRate;
	}
	public void setStarRate(int starRate) {
		this.starRate = starRate;
	}
	public int getStarCount() {
		return starCount;
	}
	public void setStarCount(int starCount) {
		this.starCount = starCount;
	}
	


	
	
}
