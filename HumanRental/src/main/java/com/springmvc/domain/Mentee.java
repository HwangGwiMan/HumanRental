package com.springmvc.domain;

public class Mentee {
	private Long menteeId;
	private String memberId;
	private String interest;
	private String introduction;
	private int starRate;
	public Long getMenteeId() {
		return menteeId;
	}
	public void setMenteeId(Long menteeId) {
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
	public int getStarRate() {
		return starRate;
	}
	public void setStarRate(int starRate) {
		this.starRate = starRate;
	}


	
}
