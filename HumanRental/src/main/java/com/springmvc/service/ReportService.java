package com.springmvc.service;

import javax.servlet.http.HttpServletRequest;

public interface ReportService {
	void createBoardReport(HttpServletRequest request, String reporterId);

}
