package com.dnjh.spring.test.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnjh.spring.test.database.domain.store;
import com.dnjh.spring.test.database.repository.StoreRepository;

@Service
public class StoreService {
	
	@Autowired
	private StoreRepository storeRepository;
	
	public List<store> getStoreList()
	{
		List<store> storeList = storeRepository.selectStoreList();
		return storeList;
	}
}
