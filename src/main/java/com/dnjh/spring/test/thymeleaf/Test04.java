package com.dnjh.spring.test.thymeleaf;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	// @RequestParam의 파라미터명과 받는 변수명이 같은 경우 @Requestparam 뒤의 파라미터명은 안 붙여도됨.
	//  @RequestParam String weather 와 같이 가능
	@GetMapping("/thymeleaf/test04/create")
	public String createWeather(
			 @RequestParam("date") @DateTimeFormat(pattern = "yyyy년MM월dd일") LocalDate date
			, @RequestParam("weather") String weather
			, @RequestParam("temperatures") double temperatures
			, @RequestParam("precipitation") double precipitation
			, @RequestParam("microDust") String microDust
			, @RequestParam("windSpeed") double windSpeed)
	{
		int count = weatherService.createWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		return "redirect:/thymeleaf/test04/info";
	}
	
	@GetMapping("/thymeleaf/test04/input")
	public String inputWeather()
	{
		return "thymeleaf/test04-input";
	}
}
