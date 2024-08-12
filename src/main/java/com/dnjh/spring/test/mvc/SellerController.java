package com.dnjh.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dnjh.spring.test.mvc.domain.Seller;
import com.dnjh.spring.test.mvc.service.SellerService;

@Controller
public class SellerController {
	@Autowired
	private SellerService sellerService;
	
	@GetMapping("/mvc/seller/1")
	public String sellerInfo(Model model)
	{
		Seller seller = sellerService.getSeller();
		
		return "mvc/sellerInput";
	}
	
	@GetMapping("/mvc/seller/output")
	public String sellerOutput()
	{
		return "mvc/sellerOutput";
	}
	
}
