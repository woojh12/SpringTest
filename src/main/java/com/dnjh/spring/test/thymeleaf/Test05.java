package com.dnjh.spring.test.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test05 {
	
	@GetMapping("/thymeleaf/test05/info")
	public String storeInfo()
	{
		return "thymeleaf/test05-info";
	}
}
