package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07")
@RestController
public class Lesson07RestController {
	
	@Autowired
	private StudentBO studentBO;
	
	//c : create
	@GetMapping("/ex01/create")
	public StudentEntity create() {
		String name = "이재현";
		String phoneNumber = "01000000000";
		String email = "ssofsl@lions.com";
		String dreamJob = "야구선수";
		
		//save 된 객체를 리턴하므로 id값이 채워져 있다.
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
	
	//u : update
	@GetMapping("/ex01/update")
	public StudentEntity update() {
		//id가 5번인 dreamJob 변경
		return studentBO.updateStudentDreamJobById(5, "유격수");
	}
	
	//d : delete
	@GetMapping("/ex01/delete")
	public String delete() {
//		id : 3 삭제 
		studentBO.deleteStudentById(3);
		return "삭제완료";
	}
}
