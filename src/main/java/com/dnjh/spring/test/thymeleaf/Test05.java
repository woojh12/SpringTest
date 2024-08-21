package com.dnjh.spring.test.thymeleaf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dnjh.spring.test.database.domain.store;
import com.dnjh.spring.test.database.service.StoreService;

@Controller
public class Test05 {
	@Autowired
	private StoreService storeService;
	@GetMapping("/thymeleaf/test05/info")
	public String storeInfo(Model model)
	{
		List<store> storeList = storeService.getStoreList();
		
		model.addAttribute("storeList", storeList);
		
		return "thymeleaf/test05-info";
	}
}
