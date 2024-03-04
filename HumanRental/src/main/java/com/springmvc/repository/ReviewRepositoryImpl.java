package com.springmvc.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.springmvc.domain.Board;
import com.springmvc.domain.Buying;
import com.springmvc.domain.Reservation;
import com.springmvc.domain.Review;
import com.springmvc.domain.Selling;
import com.springmvc.util.Utility;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository{
	
	// JDBC
	private JdbcTemplate template;

	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	Utility util = new Utility();

	@Override
	public void BuyReviewWrite(Review review) {
		
		String sql = "insert into BuyingReview values(?,?,?,?,?,?,?)";
		template.update(sql, util.createId("buyingReview"), review.getBoardId(), review.getMemberId(), review.getTitle(), 
				review.getContent(), LocalDateTime.now(), review.getStarRate());
	}

	@Override
	public void SellReviewWrite(Review review) {

		String sql = "insert into SellingReview values(?,?,?,?,?,?,?)";
		template.update(sql, util.createId("sellingReview"), review.getBoardId(), review.getMemberId(), review.getTitle(), 
				review.getContent(), LocalDateTime.now(), review.getStarRate());
	}

	@Override
	public Review getReviewByResvId(Reservation reservation, String memberId) {
		
		String sql;
		Review review = new Review();
		if(reservation.getBoardId().contains("buy")) {
			sql = "select * from BuyingReview where buyingId = ? and memberId = ?";
			review = template.query(sql, new ReviewRowMapper(), reservation.getBoardId(), memberId).get(0);
		}
		else {
			sql = "select * from SellingReview where sellingId = ? and memberId = ?";
			review = template.query(sql, new ReviewRowMapper(), reservation.getBoardId(), memberId).get(0);
		}
		return review;
	}

	@Override
	public void ReviewCheck(Reservation reservation, String memberId) {
		
		String sql;
		if(reservation.getBoardId().contains("buy")) {
			sql = "select * from BuyingReview where memberId = ?";
			template.query(sql, new ReviewRowMapper(), memberId);
		}
		else {
			sql = "select * from SellingReview where memberId = ?";
			template.query(sql, new ReviewRowMapper(), memberId);
		}
	}
	
	
}