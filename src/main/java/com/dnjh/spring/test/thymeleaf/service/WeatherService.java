package com.dnjh.spring.test.thymeleaf.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnjh.spring.test.thymeleaf.domain.WeatherHistory;
import com.dnjh.spring.test.thymeleaf.repository.WeatherRepository;

@Service
public class WeatherService {
	@Autowired
	private WeatherRepository weatherRepository;
	
	public List<WeatherHistory> getWeather()
	{	
		List<WeatherHistory> list = weatherRepository.selectWeather();
		
		return list;
	}
}
