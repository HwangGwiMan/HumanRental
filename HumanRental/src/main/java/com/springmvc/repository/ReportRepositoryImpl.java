package com.springmvc.repository;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.util.Utility;

@Repository
public class ReportRepositoryImpl implements ReportRepository {
	
	Utility util = new Utility();
	
	// JDBC
	private JdbcTemplate template;

	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void createBoardReport(HttpServletRequest request, String reporterId) {
		String SQL = "INSERT INTO report VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		template.update(SQL, util.createId("report"), request.getParameter("memberId"), reporterId, request.getParameter("target"), request.getParameter("boardId"), request.getParameter("type"), LocalDateTime.now());
	}
	
	
}
