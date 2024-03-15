package com.springmvc.domain;

import java.time.LocalDateTime;

public class Selling {
	private String sellingId;
	private String memberId;
	private String nickname;
	private String introduction;
	private float starRate;
	private String title;
	private String content;
	private String regist_day;
	private String category;
	private int price;
	private String location;
	private int starCount;
	
	
	public int getStarCount() {
		return starCount;
	}
	public void setStarCount(int starCount) {
		this.starCount = starCount;
	}
	public String getSellingId() {
		return sellingId;
	}
	public void setSellingId(String sellingId) {
		this.sellingId = sellingId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegist_day() {
		return regist_day;
	}
	public void setRegist_day(String regist_day) {
		this.regist_day = regist_day;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
