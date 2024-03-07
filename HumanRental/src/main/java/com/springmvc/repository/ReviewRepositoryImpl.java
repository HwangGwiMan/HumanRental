package com.springmvc.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.springmvc.domain.Board;
import com.springmvc.domain.Buying;
import com.springmvc.domain.Mentee;
import com.springmvc.domain.Mentor;
import com.springmvc.domain.MentorProfile;
import com.springmvc.domain.Reservation;
import com.springmvc.domain.Review;
import com.springmvc.domain.Selling;
import com.springmvc.util.Utility;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository {

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
	public void MemberReviewWrite(Review review) {

		String sql = "insert into MemberReview values(?,?,?,?,?,?,?)";
		template.update(sql, util.createId("memberReview"), review.getBoardId(), review.getMemberId(), review.getTitle(),
				review.getContent(), LocalDateTime.now(), review.getStarRate());
	}

	@Override
	public Review getReviewByResvId(Reservation reservation, String memberId) {

		String sql;
		Review review = new Review();
		
		if(memberId.equals(reservation.getMemberId())) {
	    	sql = "select * from MemberReview where boardId = ? and memberId = ?";
			review = template.query(sql, new ReviewRowMapper(), reservation.getBoardId(), memberId).get(0);
	    }
		else {
			if (reservation.getBoardId().contains("buy")) {
				System.out.println("바이");
				sql = "select * from BuyingReview where buyingId = ? and memberId = ?";
				review = template.query(sql, new ReviewRowMapper(), reservation.getBoardId(), memberId).get(0);
			} else if(reservation.getBoardId().contains("sell")){
				System.out.println("셀");
				sql = "select * from SellingReview where sellingId = ? and memberId = ?";
				review = template.query(sql, new ReviewRowMapper(), reservation.getBoardId(), memberId).get(0);
			} 
		}
		
		return review;
	}

	@Override
	public String ReviewCheck(Reservation reservation, String memberId) {

		String sql;
		try {
		    int check = 0;
		    if(memberId.equals(reservation.getMemberId())) {
		    	sql = "select count(*) from MemberReview where memberId = ? and boardId = ?";
		        check = template.queryForObject(sql, Integer.class, memberId, reservation.getBoardId());
		        System.out.println("작성자 진입");
		    }
		    else {
			    if (reservation.getBoardId().contains("buy")) {
			        sql = "select count(*) from BuyingReview where memberId = ? and buyingId = ?";
			        check = template.queryForObject(sql, Integer.class, memberId, reservation.getBoardId());
			        System.out.println("buy 진입");
			    } else{
			        sql = "select count(*) from SellingReview where memberId = ? and sellingId = ?";
			        check = template.queryForObject(sql, Integer.class, memberId, reservation.getBoardId());
			        System.out.println("sell 진입");
			    } 
		    }
		    System.out.println("check="+check);
		    if (check == 0) {
		        return "true";
		    } else {
		        return "false";
		    }
		} catch (DataAccessException e) {
		    e.printStackTrace();
		    return "false";
		}
	}
	
	
	@Override
	public String ReviewCheck2(Reservation reservation, String memberId) {
		
		String sql;
		Review review = new Review();
		
		try {
			if(memberId.equals(reservation.getMemberId())) {
		    	sql = "select * from MemberReview where boardId = ? and memberId = ?";
				review = template.query(sql, new ReviewRowMapper(), reservation.getBoardId(), memberId).get(0);
		    }
			else {
				if (reservation.getBoardId().contains("buy")) {
					sql = "select * from BuyingReview where buyingId = ? and memberId = ?";
					review = template.query(sql, new ReviewRowMapper(), reservation.getBoardId(), memberId).get(0);
				} else if(reservation.getBoardId().contains("sell")){
					sql = "select * from SellingReview where sellingId = ? and memberId = ?";
					review = template.query(sql, new ReviewRowMapper(), reservation.getBoardId(), memberId).get(0);
				} 
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return "false";
		}
		
		return "true";
	}

	@Override
	public void ReviewUpdate(Review review) {

		String sql;
		if (review.getBoardId().contains("buy")) {
			sql = "UPDATE buyingreview SET title = ?, content = ?, starRate = ? WHERE buyingReviewId = ?";
		} else {
			sql = "UPDATE sellingreview SET title = ?, content = ?, starRate = ? WHERE sellingReviewId = ?";
		}
		template.update(sql, review.getTitle(), review.getContent(), review.getStarRate(), review.getReviewId());
	}
	
	@Override
	public void MemberReviewUpdate(Review review) {

		String sql = "UPDATE memberreview SET title = ?, content = ?, starRate = ? WHERE memberReviewId = ?";
		template.update(sql, review.getTitle(), review.getContent(), review.getStarRate(), review.getReviewId());
	}

	@Override
	public void BoardStarRateUpdate(Review review, boolean duplication) {

		String sql;
		Buying buy;
		Selling sell;
		float star;
		float count;
		float reStar;
		float newStarRate;
		float newStarCount;
		
		if (review.getBoardId().contains("buy")) {
			sql = "select * from Buying where buyingId = ?";
			buy = template.query(sql, new BuyingRowMapper(), review.getBoardId()).get(0);

			star = buy.getStarRate();
			count = buy.getStarCount();
			reStar = review.getStarRate();
			
			if (duplication == false) {
				newStarRate = ((star * count) + reStar) / (count + 1);
				newStarCount = count + 1;
			} else {
				newStarRate = ((star * count) - star + reStar) / count;
				newStarCount = count;
			}
			sql = "UPDATE Buying SET starRate = ?, starCount = ? WHERE buyingId = ?";
			template.update(sql, newStarRate, newStarCount, review.getBoardId());
		} 
		else if (review.getBoardId().contains("sell")) {
			sql = "select * from Selling where sellingId = ?";
			sell = template.query(sql, new SellingRowMapper(), review.getBoardId()).get(0);

			star = sell.getStarRate();
			count = sell.getStarCount();
			reStar = review.getStarRate();
			
			if (duplication == false) {
				newStarRate = ((star * count) + reStar) / (count + 1);
				newStarCount = count + 1;
			} else {
				newStarRate = ((star * count) - star + reStar) / count;
				newStarCount = count;
			}
			sql = "UPDATE Selling SET starRate = ?, starCount = ? WHERE sellingId = ?";
			template.update(sql, newStarRate, newStarCount, review.getBoardId());
		}
	}
	

	@Override
	public void MentorStarRateUpdate(MentorProfile mentor, int starRate, boolean duplication) {
		
		float menStar = mentor.getStarRate();
		float menCount = mentor.getStarCount();
		float newStarRate;
		float newStarCount;
		
		if (duplication == false) {
			newStarRate = ((menStar * menCount) + starRate) / (menCount + 1);
			newStarCount = menCount + 1;
		} else {
			newStarRate = ((menStar * menCount) - menStar + starRate) / menCount;
			newStarCount = menCount;
		}
		
		String sql = "update MentorProfile set starRate = ?, starCount = ? where memberId = ?";
		template.update(sql, newStarRate, newStarCount, mentor.getMemberId());
	}

	@Override
	public void MenteeStarRateUpdate(Mentee mentee, int starRate, boolean duplication) {

		float menStar = mentee.getStarRate();
		float menCount = mentee.getStarCount();
		float newStarRate;
		float newStarCount;
		
		if (duplication == false) {
			newStarRate = ((menStar * menCount) + starRate) / (menCount + 1);
			newStarCount = menCount + 1;
		} else {
			newStarRate = ((menStar * menCount) - menStar + starRate) / menCount;
			newStarCount = menCount;
		}
		
		String sql = "update MenteeProfile set starRate = ?, starCount = ? where memberId = ?";
		template.update(sql, newStarRate, newStarCount, mentee.getMemberId());
	}

	
}