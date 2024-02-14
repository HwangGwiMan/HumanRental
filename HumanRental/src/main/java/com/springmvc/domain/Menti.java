package com.springmvc.domain;

public class Menti {
	private String mentiId;
	private String memberId;
	private String introduction;
	private int starRate;
	
	public String getMentiId() {
		return mentiId;
	}
	public void setMentiId(String mentiId) {
		this.mentiId = mentiId;
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
	public int getStarRate() {
		return starRate;
	}
	public void setStarRate(int starRate) {
		this.starRate = starRate;
	}
	
}
