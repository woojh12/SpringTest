package com.dnjh.spring.test.ajax.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnjh.spring.test.ajax.domain.Booking;
import com.dnjh.spring.test.ajax.repository.BookingRepository;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRepository;
	
	public List<Booking> getBooking()
	{
		List<Booking> booking = bookingRepository.selectBooking();
		
		return booking;
	}
	
	public int addBooking(String name, LocalDate date, int day, int headcount, String phoneNumber, String state)
	{
		int count = bookingRepository.insertBooking(name, date, day, headcount, phoneNumber, state);
		
		return count;
	}
}
