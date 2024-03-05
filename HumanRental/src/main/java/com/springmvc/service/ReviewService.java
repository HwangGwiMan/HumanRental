package com.springmvc.service;

import java.util.List;

import org.springframework.ui.Model;

import com.springmvc.domain.Buying;
import com.springmvc.domain.Reservation;
import com.springmvc.domain.Review;

public interface ReviewService {
	
	public void BuyReviewWrite(Review review);
	public void SellReviewWrite(Review review);
	public void getReviewByResvId(String reservationId, Model model, String memberId);
	public String ReviewCheck(String reservationId, Model model, String memberId);
	public void ReviewUpdate(Review review);
}
