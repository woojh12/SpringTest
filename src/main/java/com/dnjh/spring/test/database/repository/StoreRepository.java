package com.dnjh.spring.test.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dnjh.spring.test.database.domain.store;

// 데이터베이스 관련 처리
// 데이터베이스 쿼리를 통하여 수정, 추가, 삭제, 삽입 수행 
@Mapper
public interface StoreRepository {
	// store 모든 행 조회
	public List<store> selectStoreList();
}
