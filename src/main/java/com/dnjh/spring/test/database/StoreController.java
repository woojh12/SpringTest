package com.dnjh.spring.test.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dnjh.spring.test.database.domain.store;
import com.dnjh.spring.test.database.service.StoreService;

// request와 response 처리 담당
@Controller
public class StoreController {
	@Autowired
	private StoreService storeService;
	
	@RequestMapping("/db/store/list")
	@ResponseBody
	public List<store> storeList()
	{
		List<store> storeList = storeService.getStoreList();
		
		return storeList;
	}
}
