package com.springmvc.service;

import java.util.List;
import java.util.Map;

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
	public List<Report> getReportList(String sort, String sortTarget) {
		return reportRepository.getReportList(sort, sortTarget);
	}

	@Override
	public Map<String, Object> getReport(String reportId) {
		return reportRepository.getReport(reportId);
	}
	
	@Override
	public void stateUpdate(String reportId, String state) {
		reportRepository.stateUpdate(reportId, state);
	}
}
