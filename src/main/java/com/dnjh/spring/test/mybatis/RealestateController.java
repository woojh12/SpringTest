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
	
	@RequestMapping("/mybatis/real-estate/insert/1")
	@ResponseBody
	public String createRealEstateObject()
	{
		RealEstate realEstate = new RealEstate();
		realEstate.setOfficeId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(10000);
		
		int count = realEstateService.addObjectRealEstate(realEstate);
		
		return "입력 성공 : " + count;
	}
	
	@RequestMapping("/mybatis/real-estate/insert/2")
	@ResponseBody
	public String createRealEstate(@RequestParam("officeId") int officeId)
	{
		int count = realEstateService.addParamRealEstate(officeId, "썅뗴빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		
		return "입력 성공 : " + count;
	}
	
	@RequestMapping("/mybatis/real-estate/update/1")
	@ResponseBody
	public String updateRealEstate(@RequestParam("id") int id, @RequestParam("price") int price, @RequestParam("type") String type)
	{
		int count = realEstateService.updateRealEstate(id, price, type);
		
		return "수정 성공 : " + count;
	}
	
	@RequestMapping("/mybatis/real-estate/delete/1")
	@ResponseBody
	public String deleteRealEstate(@RequestParam("id") int id)
	{
		int count = realEstateService.deleteRealEstate(id);
		
		return "수정 성공 : " + count;
	}
}
