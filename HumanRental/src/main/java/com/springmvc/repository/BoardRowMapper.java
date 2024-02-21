package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.Board;

public class BoardRowMapper implements RowMapper<Board> {

	public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
		Board board = new Board();
		board.setBoardId(rs.getInt(1));
		board.setMemberId(rs.getString(2));
		board.setName(rs.getString(3));
		board.setTitle(rs.getString(4));
		board.setContent(rs.getString(5));
		board.setRegist_day(rs.getTimestamp(6).toLocalDateTime());
		board.setHit(rs.getInt(7));
		return board;
	}
}
