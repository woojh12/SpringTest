package com.dnjh.spring.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnjh.spring.test.mvc.domain.Realtor;
import com.dnjh.spring.test.mvc.repository.RealtorRepository;

@Service
public class RealtorService {
	@Autowired
	private RealtorRepository realtorRepository;
	
	public int addRealtorByObject(Realtor realtor)
	{
		int count = realtorRepository.realtorCreateByObject(realtor);
		
		return count;
	}
}
