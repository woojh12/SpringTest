package com.dnjh.spring.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnjh.spring.test.mvc.domain.Seller;
import com.dnjh.spring.test.mvc.repository.SellerRepository;

@Service
public class SellerService {
	@Autowired
	private SellerRepository sellerRepository;
	
	public Seller getSeller()
	{
		Seller seller = sellerRepository.selectSeller();
		
		return seller;
	}
}
