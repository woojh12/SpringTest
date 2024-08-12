package com.dnjh.spring.test.mvc.repository;

import org.apache.ibatis.annotations.Mapper;

import com.dnjh.spring.test.mvc.domain.Seller;

@Mapper
public interface SellerRepository {
	public Seller selectSeller();
}
