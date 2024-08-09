package com.dnjh.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dnjh.spring.test.mybatis.domain.RealEstate;

@Mapper
public interface RealEstateRepository {
	public RealEstate selectRealEstate(@Param("id") int id);
	
	public List<RealEstate> selectRentPrice(@Param("rentPrice") int rentPrice);
	
	public List<RealEstate> selectAreaPrice(@Param("area") int area, @Param("price") int price);

	public int insertObjectRealEstate(RealEstate realestate);
	
	public int insertParamRealEstate(
			@Param("officeId") int officeId
			, @Param("address") String address
			, @Param("area") int area
			, @Param("type") String type
			, @Param("price") int price
			, @Param("rentPrice") int rentPrice);
	
	public int updateRealEstate(@Param("id") int id, @Param("price") int price, @Param("type") String type);
	
	public int deleteRealEstate(@Param("id") int id);
}


