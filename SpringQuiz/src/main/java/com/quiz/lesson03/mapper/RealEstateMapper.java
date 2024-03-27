package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {

	public RealEstate selectRealEstateById(int id);
	
	public List<RealEstate> selectRealEstateListByRentPrice(int rentPrice);
	
	// xml로 파라미터를 보낼 때 한 개 밖에 보낼 수 없다.
	// 파라미터들을 하나의 Map에 담아 보낸다.
	// @Param 어노테이션을 붙이면 하나의 Map이 된다.
	public List<RealEstate> selectRealEstateListByAreaPrice(
			@Param("area") int area11111111, 
			@Param("price") int price1111111111);
	
	public int insertRealEstate(RealEstate realEstate);
	
	public int insertRealEstateAsField(
			@Param("realtorId") int realtorId, 
			@Param("address") String address, 
			@Param("area") int area, 
			@Param("type") String type, 
			@Param("price") int price, 
			@Param("rentPrice") Integer rentPrice);
	
	public int updateRealEstateById(
			@Param("id") int id, 
			@Param("type") String type, 
			@Param("price") int price);
	
	public int deleteRealEstateById(int id);
}



