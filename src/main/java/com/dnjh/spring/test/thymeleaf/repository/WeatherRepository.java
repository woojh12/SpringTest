package com.dnjh.spring.test.thymeleaf.repository;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dnjh.spring.test.thymeleaf.domain.WeatherHistory;

@Mapper
public interface WeatherRepository {
	
	public List<WeatherHistory> selectWeather();
	
	public int createWeather(
			@Param("date") LocalDate date
			, @Param("weather") String weather
			, @Param("temperatures") double temperatures
			, @Param("precipitation") double precipitation
			, @Param("microDust") String microDust
			, @Param("windSpeed") double windSpeed);
}
