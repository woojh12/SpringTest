package com.dnjh.spring.test.thymeleaf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dnjh.spring.test.thymeleaf.domain.WeatherHistory;
import com.dnjh.spring.test.thymeleaf.service.WeatherService;

@Controller
public class Test04 {
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/thymeleaf/test04/info")
	public String test04(Model model)
	{
		List<WeatherHistory> list = weatherService.getWeather();
		
		model.addAttribute("list", list);
		
		return "thymeleaf/test04-info";
	}
	
	
	@GetMapping("/thymeleaf/test04/create")
	public String createWeather()
	{
		return "";
	}
	@GetMapping("/thymeleaf/test04/input")
	public String inputWeather()
	{
		return "thymeleaf/test04-input";
	}
}
