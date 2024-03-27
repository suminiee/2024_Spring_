package com.quiz.lesson04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {
	//http://localhost/lesson04/quiz01/add-seller-view
	@PostMapping("/add-seller-view")
	public String addSellerView() {
		return "/lesson04/addSeller";
	}
}
