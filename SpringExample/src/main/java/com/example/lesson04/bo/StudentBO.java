package com.example.lesson04.bo;

import java.time.ZonedDateTime;
import java.util.Optional;

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
	
	//update
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		//기존 데이터를 조회해온다 
		StudentEntity student = studentRepository.findById(id).orElse(null); //비어있는 경우 null로 넣겠다는 의미 
		
		//데이터의 값을 변경한다 => 엔티티에 
		if (student != null) {
			student = student.toBuilder() //toBuilder는 기존 필드값을 유지하고 일부만 변경을 해주는 메소드
				.dreamJob(dreamJob)
				.build(); //꼭 다시 저장!!!! 
			student = studentRepository.save(student); //save를 하면 return값으로 수정반영된 entity를 보내줌 
		} 
		
		//save(엔티티 객체) => update id가 채워져 있으므로 update가 자동적으로 됨.  
		return student; //null or StudentEntity
	}
	
	//delete
	public void deleteStudentById(int id) {
		//방법 1)
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		if (student != null) {
//			studentRepository.delete(student);
//		}
		//방법 2)
		Optional<StudentEntity> studentOptional =  studentRepository.findById(id);
		studentOptional.ifPresent(s -> studentRepository.delete(s)); //entity를 s라는 객체라고 이름을 지은것 
		
	}
	
	//MyBatis로 insert
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	public Student getStudent(int id) {
		return studentMapper.selectStudent(id);
	}
	
	
}
