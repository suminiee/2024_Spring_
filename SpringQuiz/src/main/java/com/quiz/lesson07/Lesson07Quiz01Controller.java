package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.service.CompanyService;

@RequestMapping("/lesson07/quiz01")
@RestController
public class Lesson07Quiz01Controller {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/save1")
	public CompanyEntity create1() {
		String name = "넥슨";
		String business = "컨텐츠 게임";
		String scale = "대기업";
		int headcount = 3585;
		
		return companyService.addCompany(name, business, scale, headcount);
	}
	
	@GetMapping("/save2")
	public CompanyEntity create2() {
		String name = "버블팡";
		String business = "여신 금융업";
		String scale = "대기업";
		int headcount = 6834;
		
		return companyService.addCompany(name, business, scale, headcount);
	}
	
	
}