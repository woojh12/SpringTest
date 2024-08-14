package com.dnjh.spring.test.mvc.repository;

import org.apache.ibatis.annotations.Mapper;

import com.dnjh.spring.test.mvc.domain.Realtor;

@Mapper
public interface RealtorRepository {
	public int realtorCreateByObject(Realtor realtor);
}
