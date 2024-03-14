package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.Board;
import com.springmvc.domain.Buying;
import com.springmvc.util.Utility;

public class BuyingRowMapper implements RowMapper<Buying> {

	public Buying mapRow(ResultSet rs, int rowNum) throws SQLException {

		Utility util = new Utility();
		
		Buying buying = new Buying();
		buying.setBuyingId(rs.getString(1));
		buying.setMemberId(rs.getString(2));
		buying.setNickname(rs.getString(3));
		buying.setIntroduction(rs.getString(4));
		buying.setStarRate(rs.getFloat(5));
		buying.setTitle(rs.getString(6));
		buying.setContent(rs.getString(7));
		buying.setRegist_day(util.outputFormatting(rs.getTimestamp(8)));
		buying.setCategory(rs.getString(9));
		buying.setPrice(rs.getInt(10));
		buying.setLocation(rs.getString(11));
		buying.setStarCount(rs.getInt("starCount"));
		
		return buying;
	}
}
