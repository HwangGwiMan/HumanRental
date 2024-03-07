package com.springmvc.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import com.springmvc.domain.Report;

public interface ReportService {
	public void createBoardReport(HttpServletRequest request, String reporterId);
	public List<Report> getReportList(String sort, String sortTarget);
	public Map<String, Object> getReport(String reportId);
	void stateUpdate(String reportId, String state);
}
