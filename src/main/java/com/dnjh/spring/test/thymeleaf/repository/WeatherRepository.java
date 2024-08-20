package com.dnjh.spring.test.thymeleaf.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dnjh.spring.test.thymeleaf.domain.WeatherHistory;

@Mapper
public interface WeatherRepository {
	
	public List<WeatherHistory> selectWeather();
}
