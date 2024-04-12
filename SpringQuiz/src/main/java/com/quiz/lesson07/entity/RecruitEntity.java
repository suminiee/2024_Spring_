package com.quiz.lesson07.entity;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Builder(toBuilder = true)
@NoArgsConstructor //파라미터 없는 생성자 
@Getter
@AllArgsConstructor
@Entity
@Table(name = "recruit")
public class RecruitEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="companyId")
	private int companyId;
	
	@Column(name ="position")
	private String position;
	
	@Column(name ="responsibilities")
	private String responsibilities;
	
	@Column(name ="qualification")
	private String qualification;
	
	@Column(name ="type")
	private String type;
	
	@Column(name ="region")
	private String region;
	
	@Column(name ="salary")
	private int salary;
	
	@Column(name ="deadline")
	private LocalDate deadline;
	
	@UpdateTimestamp //시간 값을 넣지 않아도 현재 시간으로 자동으로 넣어 줌
	@Column(name = "createdAt", updatable = false) //업데이트시 시간 변경을 막음 
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private ZonedDateTime updatedAt;
	

}
