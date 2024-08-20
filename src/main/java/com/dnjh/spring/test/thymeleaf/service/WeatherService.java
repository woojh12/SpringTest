package com.dnjh.spring.test.thymeleaf.service;

import java.time.LocalDate;
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
	
	public int createWeather(LocalDate date, String weather, double temperatures, double precipitation, String microDust, double windSpeed)
	{
		int count = weatherRepository.createWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		return count;
	}
}
