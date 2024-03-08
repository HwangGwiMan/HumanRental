package com.springmvc.repository;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.springmvc.domain.Report;

public interface ReportRepository {
	public void createBoardReport(HttpServletRequest request, String reporterId);
	public List<Report> getReportList(String sort, String sortTarget);
	public Map<String, Object> getReport(String reportId);
	void stateUpdate(String reportId, String state);
	
}
