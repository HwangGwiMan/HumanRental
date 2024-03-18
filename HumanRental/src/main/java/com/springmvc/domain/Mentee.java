package com.springmvc.domain;

public class Mentee {
	
	private String menteeId;
	private String memberId;
	private String interest;
	private String introduction;
	private String menteeprofileaddress; 
	private float starRate;
	public String getMenteeprofileaddress() {
		return menteeprofileaddress;
	}
	public void setMenteeprofileaddress(String menteeprofileaddress) {
		this.menteeprofileaddress = menteeprofileaddress;
	}
	private int starCount;
	
	public String getMenteeId() {
		return menteeId;
	}
	public void setMenteeId(String menteeId) {
		this.menteeId = menteeId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public float getStarRate() {
		return starRate;
	}
	public void setStarRate(float starRate) {
		this.starRate = starRate;
	}
	public int getStarCount() {
		return starCount;
	}
	public void setStarCount(int starCount) {
		this.starCount = starCount;
	}
	
	
}
