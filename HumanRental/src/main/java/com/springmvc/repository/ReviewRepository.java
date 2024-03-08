package com.springmvc.repository;

import java.util.List;

import org.springframework.ui.Model;

import com.springmvc.domain.Buying;
import com.springmvc.domain.Mentee;
import com.springmvc.domain.Mentor;
import com.springmvc.domain.MentorProfile;
import com.springmvc.domain.Reservation;
import com.springmvc.domain.Review;

public interface ReviewRepository {
	
	public void BuyReviewWrite(Review review);
	public void SellReviewWrite(Review review);
	public void MemberReviewWrite(Review review);
	public Review getReviewByResvId(Reservation reservation, String memberId);
	public String ReviewCheck(Reservation reservation, String memberId);
	public String ReviewCheck2(Reservation reservation, String memberId);
	public void ReviewUpdate(Review review);
	public void MemberReviewUpdate(Review review);
	public void BoardStarRateUpdate(Review review, boolean duplication);
	public void MentorStarRateUpdate(MentorProfile mentor, int starRate, boolean duplication);
	public void MenteeStarRateUpdate(Mentee mentee, int starRate, boolean duplication);
	public List<Review> getReviewList(String boardId);
	}
