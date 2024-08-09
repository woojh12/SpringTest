package com.dnjh.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dnjh.spring.test.mybatis.domain.RealEstate;
import com.dnjh.spring.test.mybatis.service.RealEstateService;

@Controller
public class RealestateController {
	@Autowired
	private RealEstateService realEstateService;
	
	@RequestMapping("/mybatis/real-estate/select/1")
	@ResponseBody
	public RealEstate realestate(@RequestParam("id") int id)
	{
		RealEstate realEstate = realEstateService.getRealEstate(id);
		
		return realEstate;
	}
	
	@RequestMapping("/mybatis/real-estate/select/2")
	@ResponseBody
	public List<RealEstate> rentPrice(@RequestParam("rentPrice") int rentPrice)
	{
		List<RealEstate> list = realEstateService.getRentPrice(rentPrice);
		
		return list;
	}
	
	@RequestMapping("/mybatis/real-estate/select/3")
	@ResponseBody
	public List<RealEstate> areaPrice(@RequestParam("area") int area, @RequestParam("price") int price)
	{
		List<RealEstate> list = realEstateService.getAreaPrice(area, price);
		
		return list;
	}
}
