package com.springmvc.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.springmvc.domain.Report;

public interface ReportService {
	public void createBoardReport(HttpServletRequest request, String reporterId);
	public List<Report> getReportList();
}
