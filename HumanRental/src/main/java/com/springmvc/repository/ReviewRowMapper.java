package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.Review;

public class ReviewRowMapper implements RowMapper<Review>{
	
	public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Review review = new Review(); 
		review.setReviewId(rs.getString(1));
		review.setBoardId(rs.getString(2));
		review.setMemberId(rs.getString(3));
		review.setTitle(rs.getString(4));
		review.setContent(rs.getString(5));
		review.setWriteDate(rs.getTimestamp(6).toLocalDateTime());
		review.setStarRate(rs.getInt(7));
 
		return review;
		 
	}

}
