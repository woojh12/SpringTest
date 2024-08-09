package com.dnjh.spring.test.mybatis.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnjh.spring.test.mybatis.domain.RealEstate;
import com.dnjh.spring.test.mybatis.repository.RealEstateRepository;

@Service
public class RealEstateService {
	@Autowired
	private RealEstateRepository realEstateRepository;
	
	public RealEstate getRealEstate(int id)
	{
		RealEstate realEstate = realEstateRepository.selectRealEstate(id);
		
		return realEstate;
	}
	
	public List<RealEstate> getRentPrice(Integer rentPrice)
	{
		List<RealEstate> list = realEstateRepository.selectRentPrice(rentPrice);
		
		return list;
	}
	
	public List<RealEstate> getAreaPrice(int area, int price)
	{
		List<RealEstate> list = realEstateRepository.selectAreaPrice(area, price);
		
		return list;
	}
}
