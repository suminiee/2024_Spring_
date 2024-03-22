package com.example.lesson02.domain;

import java.util.Date;

//일반 자바 bean
//domain, DTO, Entity

public class UsedGoods {
	private int id;
	private int sellderId;
	private String title;
	private String description;
	private int price;
	private String picture;
	private Date createdAt;
	private Date updatedAt;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSellderId() {
		return sellderId;
	}
	public void setSellderId(int sellderId) {
		this.sellderId = sellderId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdateAt() {
		return updatedAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updatedAt = updateAt;
	}
	
	
}
