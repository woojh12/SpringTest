package com.dnjh.spring.test.mvc.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dnjh.spring.test.mvc.domain.Seller;

@Mapper
public interface SellerRepository {
	// Param은 xml파일의 파라미터명과 동일해야함
	// 닉네임, 매너온도, 프로필 이미지 경로 전달 받고 한행을 insert하는 기능
	public int insertSeller(
			@Param("nickName") String nickname
			, @Param("temperature") double tempearture
			, @Param("profile") String profileImage);
	
	public Seller getLastSeller();
	
	public Seller selectSeller(@Param("id") int id);
}
