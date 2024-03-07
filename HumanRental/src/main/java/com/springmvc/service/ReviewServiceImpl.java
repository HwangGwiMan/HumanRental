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
import com.springmvc.domain.MentorProfile;
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
	
	@Autowired
	MentorRepository mentorRepository;

	@Autowired
	MenteeRepository menteeRepository;

	@Autowired
	MemberRepository memberRepository;
	
	@Override
	public void BuyReviewWrite(Review review) {
		reviewRepository.BuyReviewWrite(review);
		reviewRepository.BoardStarRateUpdate(review, false);;
	}

	@Override
	public void SellReviewWrite(Review review) {
		reviewRepository.SellReviewWrite(review);
		reviewRepository.BoardStarRateUpdate(review, false);;
	}
	
	@Override
	public void MemberReviewWrite(Review review) {
		reviewRepository.MemberReviewWrite(review);
	}

	@Override
	public void getReviewByResvId(String reservationId, Model model, String memberId) {
	 	Reservation reservation = (Reservation)model.getAttribute("reservation");
	 	Review review = reviewRepository.getReviewByResvId(reservation, memberId);
	 	model.addAttribute("review", review);
	}

	@Override
	public String ReviewCheck(String reservationId, Model model, String memberId) {
		Reservation reservation = (Reservation)model.getAttribute("reservation");
	 	String check =reviewRepository.ReviewCheck(reservation, memberId);
	 	return check;
	}
	
	@Override
	public String ReviewCheck2(String reservationId, Model model, String memberId) {
	 	Reservation reservation = (Reservation)model.getAttribute("reservation");
	 	String check = reviewRepository.ReviewCheck2(reservation, memberId);
	 	return check;
	}

	@Override
	public void ReviewUpdate(Review review) {
		reviewRepository.ReviewUpdate(review);
		reviewRepository.BoardStarRateUpdate(review, true);;
	}

	@Override
	public void MemberReviewUpdate(Review review) {
		reviewRepository.MemberReviewUpdate(review);
	}

	@Override
	public void StarRateUpdate(String memberId, Review review, boolean duplication) {
		
		if(review.getBoardId().contains("buy")) {
			Mentee mentee =  menteeRepository.getInformation(memberId);
			reviewRepository.MenteeStarRateUpdate(mentee, review.getStarRate(), duplication);
		}
		else {
			MentorProfile mentor = mentorRepository.MentorprofileInformation(memberId);
			reviewRepository.MentorStarRateUpdate(mentor, review.getStarRate(), duplication);
		}
	}
	

	@Override
	public void StarRateUpdate2(String applicantMemberId, Review review, boolean duplication) {
		
		if(review.getBoardId().contains("buy")) {
			MentorProfile mentor = mentorRepository.MentorprofileInformation(applicantMemberId);
			reviewRepository.MentorStarRateUpdate(mentor, review.getStarRate(), duplication);
		}
		else {
			Mentee mentee =  menteeRepository.getInformation(applicantMemberId);
			reviewRepository.MenteeStarRateUpdate(mentee, review.getStarRate(), duplication);
		}
	}
	
	public List<Review> getReviewList(String boardId) {
		List<Review> list = reviewRepository.getReviewList(boardId);
		for(Review review : list) {
			review.setNickname(memberRepository.getMember(review.getMemberId()).getNickName());
		}
		return list;
	}
}