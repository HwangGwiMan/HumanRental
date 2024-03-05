package com.springmvc.domain;

import java.time.LocalDateTime;

public class Buying {
	private String buyingId;
	private String memberId;
	private String nickname;
	private String introduction;
	private int starRate;
	private String title;
	private String content;
	private LocalDateTime regist_day;
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
	public String getBuyingId() {
		return buyingId;
	}
	public void setBuyingId(String buyingId) {
		this.buyingId = buyingId;
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
	public int getStarRate() {
		return starRate;
	}
	public void setStarRate(int starRate) {
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
	public LocalDateTime getRegist_day() {
		return regist_day;
	}
	public void setRegist_day(LocalDateTime regist_day) {
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
