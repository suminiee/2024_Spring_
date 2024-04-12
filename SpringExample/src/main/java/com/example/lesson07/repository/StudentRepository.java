package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lesson07.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{
	//Spring Data JPA vs 순수 JPA
	//public StudentEntity save(StudentEntity student);
	//public StudentEntity findById(int id)
	//public void delete(StudentEntity entity)
	//findAll -> 모든걸 다 조회하겠다 
	
	//ex02/select JPQL
	public List<StudentEntity> findAllByOrderByIdDesc();
	
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	
	public List<StudentEntity> findByName(String name);
	
	public List<StudentEntity> findByNameIn(List<String> name);
	
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	
	public List<StudentEntity> findByEmailContains(String domain);
	
	public List<StudentEntity> findByNameStartingWith(String keyword);
	
	public List<StudentEntity> findByIdBetween(int start, int end);
	
	
}
