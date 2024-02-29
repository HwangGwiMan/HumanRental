package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Report;
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
	public List<Report> getReportList() {
		String SQL;
				
		try {
			SQL = "SELECT * FROM report";
			return template.query(SQL, new RowMapper<Report>() {
				
				@Override
				public Report mapRow(ResultSet rs, int rowNum) throws SQLException {
					Report report = new Report();
					report.setReportId(rs.getString(1));
					report.setMemberId(rs.getString(2));
					report.setReporterId(rs.getString(3));
					report.setTarget(rs.getString(4));
					report.setTargetId(rs.getString(5));
					report.setType(rs.getString(6));
					report.setState(rs.getString(7));
					report.setCreateDate(rs.getTimestamp(8));

					return report;
				}
				
			});
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	@Override
	public Map<String, Object> getReport(String reportId) {
		String SQL;
		
		try {
			SQL = "SELECT report.reportId, board.boardId, board.memberId, board.title, report.type, member.reportCount FROM report "
					+ "LEFT JOIN board "
					+ "ON board.boardId = report.targetId "
					+ "LEFT JOIN member "
					+ "ON board.memberId = member.memberId "
					+ "WHERE reportId = ?;";
			
			return template.queryForMap(SQL, reportId);
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	@Override
	public void stateUpdate(String reportId, String state) {
		String SQL;
		
		SQL = "UPDATE report SET state = ? WHERE reportId = ?";
		template.update(SQL, state, reportId);
	}
	
	@Override
	public void createBoardReport(HttpServletRequest request, String reporterId) {
		String SQL;
				
		SQL = "INSERT INTO report VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		template.update(SQL, util.createId("report"), request.getParameter("memberId"), reporterId, request.getParameter("target"), request.getParameter("boardId"), request.getParameter("type"), "Wait" ,LocalDateTime.now());
		
		SQL = "SELECT reportCount FROM member WHERE memberId = ?";
		int reportCount = template.queryForObject(SQL, Integer.class, request.getParameter("memberId"));
		reportCount++;
		SQL = "UPDATE member SET reportCount = ? WHERE memberId = ?";
		template.update(SQL, reportCount, request.getParameter("memberId"));
	}
	
	
}
