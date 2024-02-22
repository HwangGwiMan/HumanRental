package com.springmvc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Report;
import com.springmvc.repository.ReportRepository;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	ReportRepository reportRepository;
	
	@Override
	public void createBoardReport(HttpServletRequest request, String reporterId) {
		reportRepository.createBoardReport(request, reporterId);
	}

	@Override
	public List<Report> getReportList() {
		return reportRepository.getReportList();
	}
	
}
