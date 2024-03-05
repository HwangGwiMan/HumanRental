package com.springmvc.repository;

import java.util.List;

import org.springframework.ui.Model;

import com.springmvc.domain.Buying;
import com.springmvc.domain.Reservation;
import com.springmvc.domain.Review;

public interface ReviewRepository {
	
	public void BuyReviewWrite(Review review);
	public void SellReviewWrite(Review review);
	public Review getReviewByResvId(Reservation reservation, String memberId);
	public void ReviewCheck(Reservation reservation, String memberId);
}
