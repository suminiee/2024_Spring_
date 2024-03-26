package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewMapper reviewMapper;
	
	public Review getReview(int id) {
		return reviewMapper.selectReview(id);
	}
	
	public int addReview(Review review) {
		return reviewMapper.insertReview(review);
	}
	
	public int addReviewAsField(int storeId0, String menu0, String userName0, Double point0, String review0) {
		return reviewMapper.insertReviewAsField(storeId0, menu0, userName0, point0, review0);
	}
	
}
