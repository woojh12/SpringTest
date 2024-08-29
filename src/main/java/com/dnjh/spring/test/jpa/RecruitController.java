package com.dnjh.spring.test.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dnjh.spring.test.jpa.domain.Recruit;
import com.dnjh.spring.test.jpa.repository.RecruitRepository;

@RestController // @Controller +  @Response 
@Controller
public class RecruitController {
	@Autowired
	private RecruitRepository recruitRepository;
	
	@GetMapping("/jpa/recruit/find1")
	@ResponseBody
	public Recruit recruitFind1()
	{
		Recruit recruit = recruitRepository.findById(8);
	
		return recruit;		
	}
	
	@GetMapping("/jpa/recruit/find2")
	@ResponseBody
	public Recruit recruitFind2(
			@RequestParam("id") int id)
	{
		Recruit recruit = recruitRepository.findById(id);
		
		return recruit;
	}
	
	@GetMapping("/jpa/recruit/find3")
	@ResponseBody
	public List<Recruit> recruitFind3()
	{
		List<Recruit> recruitList = recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
		
		return recruitList;
	}
	
	@GetMapping("/jpa/recruit/find4")
	@ResponseBody
	public List<Recruit> recruitFind4()
	{
		List<Recruit> recruitList = recruitRepository.findByTypeOrSalary("정규직", 9000);
		
		return recruitList;
	}
	
	@GetMapping("/jpa/recruit/find5")
	@ResponseBody
	public List<Recruit> recruitFind5()
	{
		List<Recruit> recruitList = recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
		
		return recruitList;
	}
	
	@GetMapping("/jpa/recruit/find6")
	@ResponseBody
	public List<Recruit> recruitFind6()
	{
		List<Recruit> recruitList = recruitRepository.findByRegionAndSalaryBetweenOrderByIdAsc("성남시 분당구", 7000, 8000);
		
		return recruitList;
	}
	
	@GetMapping("/jpa/recruit/find7")
	@ResponseBody
	public List<Recruit> recruitFind7()
	{
		List<Recruit> recruitList = recruitRepository.selectBydeadLine("2026-04-10", 8100, "정규직");
		return recruitList;
	}
}
