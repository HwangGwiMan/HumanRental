package com.springmvc.domain;

import java.time.LocalDateTime;

public class Report {
	private String reportId;
	private String memberId;
	private String reporterId;
	private String target;
	private String targetId;
	private String type;
	private String state;
	private Object createDate;
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getReporterId() {
		return reporterId;
	}
	public void setReporterId(String reporterId) {
		this.reporterId = reporterId;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Object getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Object createDate) {
		this.createDate = createDate;
	}
	
}
