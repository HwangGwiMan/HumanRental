package com.springmvc.domain;

import java.time.LocalDateTime;

public class Review {
	private String ReviewId;
	private String boardId;
	private String memberId;
	private String title;
	private String content;
	private LocalDateTime writeDate;
	private int starRate;
	
	
	public String getReviewId() {
		return ReviewId;
	}
	public void setReviewId(String reviewId) {
		ReviewId = reviewId;
	}
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
	public LocalDateTime getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(LocalDateTime writeDate) {
		this.writeDate = writeDate;
	}
	public int getStarRate() {
		return starRate;
	}
	public void setStarRate(int starRate) {
		this.starRate = starRate;
	}
	
	
}
