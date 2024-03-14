package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.Review;
import com.springmvc.util.Utility;

public class ReviewRowMapper implements RowMapper<Review>{
	
	public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Utility util = new Utility();
		
		Review review = new Review(); 
		review.setReviewId(rs.getString(1));
		review.setBoardId(rs.getString(2));
		review.setMemberId(rs.getString(3));
		review.setTitle(rs.getString(4));
		review.setContent(rs.getString(5));
		review.setWriteDate(util.outputFormatting(rs.getTimestamp(6)));
		review.setStarRate(rs.getInt(7));
		review.setReservationId(rs.getString("reservationId"));
 
		return review;
		 
	}

}
