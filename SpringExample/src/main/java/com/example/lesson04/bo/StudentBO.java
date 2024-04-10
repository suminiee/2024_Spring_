package com.example.lesson04.bo;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {
	
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private StudentRepository studentRepository;
	
	//JPA로 insert - method name이 같아도 input이 다르면 오버로딩
	//setter 대용으로 builder로 데이터 주입해줌
	public StudentEntity addStudent(String name, String phoneNumber, String email, String dreamJob) {
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(ZonedDateTime.now())
				.build();
		
		return studentRepository.save(student);
	}
	
	//MyBatis로 insert
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	public Student getStudent(int id) {
		return studentMapper.selectStudent(id);
	}
}
