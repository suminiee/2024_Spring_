package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.domain.Review;

@RestController
public class Lesson03Ex01Controller {
	
	@Autowired
	private ReviewBO reviewBO;
	
	//url : localhost/lesson03/ex01
	@RequestMapping("/lesson03/ex01")
	public Review ex01() {
		return reviewBO.getReview();
	}
}
