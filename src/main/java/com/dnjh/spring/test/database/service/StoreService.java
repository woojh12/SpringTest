package com.dnjh.spring.test.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnjh.spring.test.database.domain.store;
import com.dnjh.spring.test.database.repository.StoreRepository;

// 로직 담당
@Service
public class StoreService {
	@Autowired
	private StoreRepository storeRepository;
	
	// 가게 정보 리스트 리턴 기능
	public List<store> getStoreList()
	{
		// store 테이블 모든 행 조회 
		List<store> storeList = storeRepository.selectStoreList();
		return storeList;
	}
}
