package com.quiz.booking.domain;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Booking {
	private int id;
	private String name;
	private int headcount;
	private int day;
	private Date date;
	private String phoneNumber;
	private String state;
	private Date createdAt;
	private Date updatedAt;
	
}