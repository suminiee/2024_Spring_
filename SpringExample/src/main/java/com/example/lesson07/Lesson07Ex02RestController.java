package com.example.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@RequestMapping("/lesson07/ex02")
@RestController
public class Lesson07Ex02RestController {
	@Autowired
	private StudentRepository studentRepository;
	
	//조회하는 다양한 방법
	@GetMapping("/select1")
	public List<StudentEntity> select1() {
		//1) 전체조회
//		return studentRepository.findAll();
		
		//2) id기준 내림차순 전체조회
//		return studentRepository.findAllByOrderByIdDesc();
		
		//3) id기준 내림차순 3개만조회 
//		return studentRepository.findTop3ByOrderByIdDesc();
		
		//4) 이름 가지고 데이터 조회 
//		return studentRepository.findByName("이재현");
		
		//5) in문으로 일치하는 값 모두 조회
		//유재석, 이재현 
//		return studentRepository.findByNameIn(List.of("유재석" , "이재현"));
		
		//6) 여러 컬럼값과 일치하는 데이터 조회
//		return studentRepository.findByNameAndDreamJob("이재현", "유격수");
		
		//7) 이메일 컬럼에 @naver.com이 포함된 데이터 조회
//		return studentRepository.findByEmailContains("@naver.com");
		
		//8) 성씨가지고 데이터 조회 이%
//		return studentRepository.findByNameStartingWith("이");
		
		//9) id가 2~5 조회 
//		return studentRepository.findByIdBetween(2, 5);
		
		return studentRepository.findByDreamJob("유격수");
	}
	
}
