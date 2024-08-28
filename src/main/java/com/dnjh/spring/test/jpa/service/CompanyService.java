package com.dnjh.spring.test.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnjh.spring.test.jpa.domain.Company;
import com.dnjh.spring.test.jpa.repository.CompanyRepository;

@Service
public class CompanyService {
	@Autowired
	private CompanyRepository companyRepository;
	
	public Company addCompany(String name, String business, String scale, int headcount)
	{
		Company company = Company.builder()
							.name(name)
							.business(business)
							.scale(scale)
							.headcount(headcount)
							.build();
		
		Company result = companyRepository.save(company);
		
		return result;
	}
	
	public Company updateCompany(int id, String scale, int headcount)
	{
		Optional<Company> optionalCompany = companyRepository.findById(id);
		
		Company company = optionalCompany.orElse(null);
		
		company = company.toBuilder().scale(scale).headcount(headcount).build();
		
		Company result = companyRepository.save(company);
		
		return result;
	}
	
	public void deleteCompany(int id)
	{
		Optional<Company> optionalCompany = companyRepository.findById(id);
		
		// 1. 반환받는 객체가 null인 경우 처리  
//		Company company = optionalCompany.orElse(null);
//		
//		if(company != null)
//		{
//			companyRepository.delete(company);			
//		}
		
		// 2. 반환받는 객체가 null인 경우 처리  
//		if(optionalCompany.isPresent())
//		{
//			companyRepository.delete(optionalCompany.get());
//		}
		
		// 3. 반환받는 객체가 null인 경우 처리  
		// null이 아닐때 수행할 기능을 등록
		// c : optionalCompany
		optionalCompany.ifPresent(c -> companyRepository.delete(c));
	}
}
