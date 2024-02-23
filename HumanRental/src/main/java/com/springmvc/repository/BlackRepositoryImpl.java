package com.springmvc.repository;

import java.time.LocalDateTime;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springmvc.domain.Black;
import com.springmvc.util.Utility;

public class BlackRepositoryImpl implements BlackRepository {
	
	Utility util = new Utility();
	
	// JDBC
	JdbcTemplate template;
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void registBlack(Black black) {
		String SQL = "INSERT INTO blacklist VALUES(?, ?, ?, ?)";
		
		black.setBlackId(util.createId("black"));
		template.update(SQL,  black.getBlackId(), black.getMemberId(), black.getReportId(), LocalDateTime.now());
	}

}
