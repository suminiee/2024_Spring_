package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.domain.Student;

@RequestMapping("/lesson04/ex02")
@Controller
public class Lesson04Ex02Controller {
	
	@Autowired
	private StudentBO studentBO;
	
	@GetMapping("/add-student-review")
	public String addStudentReview() {
		return "lesson04/addStudent";
	}
	
	//DB insert -> 방금 가입된 학생 화면 
	//http://localhost/lesson04/ex02/add-student
	@PostMapping("/add-student")
	public String addStudent(@ModelAttribute Student student, Model model) { //@ModelAttribute 어노테이션은 안붙여도 자동으로 붙여졌다고 여겨짐 
		//jsp form 태그의 name == Student 필드명 => 매핑 // 알아서 채워
		
		//DB Insert
		studentBO.addStudent(student);
		
		//DB Select => 방금 가입된 학생 
//		student.getId(); //여기에 최근 저장된 학생 id가 담겨져 있게 됨. 
		int id = student.getId();
		Student newStudent = studentBO.getStudent(id);
		
		//Model에 담는다. 최근 학생
		model.addAttribute("result", newStudent);
		model.addAttribute("title", "학생 정보");
		
		//화면 이동 
		return "lesson04/afterAddStudent";
	}
}
