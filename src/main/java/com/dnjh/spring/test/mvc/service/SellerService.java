package com.dnjh.spring.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnjh.spring.test.mvc.domain.Seller;
import com.dnjh.spring.test.mvc.repository.SellerRepository;

@Service
public class SellerService {
	@Autowired
	private SellerRepository sellerRepository;
	
	public int addSeller(String nickname, double temperature, String profileImage)
	{
		// 닉네임, 매너온도, 프로필 이미지 경로 전달 받고 판매자 정보 저장
		int count = sellerRepository.insertSeller(nickname, temperature, profileImage);
		return count;
	}
	
	public Seller getLastSeller()
	{
		Seller seller = sellerRepository.getLastSeller();
		
		return seller;
	}
	
	public Seller getSeller(int id)
	{
		Seller seller = sellerRepository.selectSeller(id);
		
		return seller;
	}
}
