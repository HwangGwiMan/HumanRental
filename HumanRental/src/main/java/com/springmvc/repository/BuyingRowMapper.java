package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.Board;
import com.springmvc.domain.Buying;

public class BuyingRowMapper implements RowMapper<Buying> {

	public Buying mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Buying selling = new Buying();
		selling.setBuyingId(rs.getString(1));
		selling.setMemberId(rs.getString(2));
		selling.setNickname(rs.getString(3));
		selling.setIntroduction(rs.getString(4));
		selling.setStarRate(rs.getInt(5));
		selling.setTitle(rs.getString(6));
		selling.setContent(rs.getString(7));
		selling.setRegist_day(rs.getTimestamp(8).toLocalDateTime());
		selling.setCategory(rs.getString(9));
		selling.setPrice(rs.getInt(10));
		selling.setLocation(rs.getString(11));
		
		return selling;
	}
}
