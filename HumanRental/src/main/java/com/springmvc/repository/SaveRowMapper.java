package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.Buying;
import com.springmvc.domain.Save;

public class SaveRowMapper implements RowMapper<Save>{

	public Save mapRow(ResultSet rs, int rowNum) throws SQLException {
	Save save = new Save();
	save.setSaveListId(rs.getString(1));
	save.setMemberId(rs.getString(2));
	save.setCategory(rs.getString(3));
	save.setNickname(rs.getString(4));
	save.setTitle(rs.getString(5));
	save.setPrice(rs.getInt(6));
	save.setContent(rs.getString(7));
	
	return save;
	}
	
}
