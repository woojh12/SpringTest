package com.dnjh.spring.test.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test04 {
	@GetMapping("/thymeleaf/test04")
	public String test04()
	{
		return "thymeleaf/test04-info";
	}
}
