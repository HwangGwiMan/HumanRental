package com.springmvc.repository;

import javax.servlet.http.HttpServletRequest;

public interface ReportRepository {
	void createBoardReport(HttpServletRequest request, String reporterId);

}
