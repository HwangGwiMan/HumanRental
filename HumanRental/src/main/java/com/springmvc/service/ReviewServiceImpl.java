package com.springmvc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.springmvc.domain.Buying;
import com.springmvc.domain.Mentee;
import com.springmvc.domain.Mentor;
import com.springmvc.domain.Reservation;
import com.springmvc.domain.Review;
import com.springmvc.domain.Selling;
import com.springmvc.repository.BuyingRepository;
import com.springmvc.repository.MemberRepository;
import com.springmvc.repository.MenteeRepository;
import com.springmvc.repository.MentorRepository;
import com.springmvc.repository.ReservationRepository;
import com.springmvc.repository.ReservationRepositoryImpl;
import com.springmvc.repository.ReviewRepository;
import com.springmvc.repository.SellingRepository;
import com.springmvc.util.Utility;

@Repository
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	ReviewRepository reviewRepository;
	
	@Override
	public void BuyReviewWrite(Review review) {
		reviewRepository.BuyReviewWrite(review);
	}

	@Override
	public void SellReviewWrite(Review review) {
		reviewRepository.SellReviewWrite(review);
		
	}

	
}