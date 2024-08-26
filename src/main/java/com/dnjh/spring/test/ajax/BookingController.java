package com.dnjh.spring.test.ajax;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dnjh.spring.test.ajax.domain.Booking;
import com.dnjh.spring.test.ajax.service.BookingService;

@Controller
public class BookingController {
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/ajax/booking/info")
	public String bookingInfo(Model model)
	{
		List<Booking> bookingList = bookingService.getBooking();
		
		model.addAttribute("bookingList", bookingList);
		
		return "ajax/booking/info";
	}
	
	@ResponseBody
	@GetMapping("/ajax/booking/delete")
	public Map<String, String> bookingDelete(@RequestParam("id") int id)
	{
		int count = bookingService.deleteBooking(id);
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1)
		{
			resultMap.put("result", "success");
		}
		else
		{
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@ResponseBody
	@GetMapping("/ajax/booking/create")
	public Map<String, String> bookingCreate(
			@RequestParam("name") String name
			, @RequestParam("date") @DateTimeFormat(pattern = "yyyy년MM월dd일") LocalDate date
			, @RequestParam("day") int day
			, @RequestParam("headcount") int headcount
			, @RequestParam("phoneNumber") String phoneNumber
			, @RequestParam("state") String state)
	{
		int count = bookingService.addBooking(name, date, day, headcount, phoneNumber, state);
		
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1)
		{
			resultMap.put("result", "success");
		}
		else
		{
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@GetMapping("/ajax/booking/reservation")
	public String bookingReserve()
	{
		return "ajax/booking/reservation";
	}
	
	@GetMapping("/ajax/booking/main")
	public String bookingMain()
	{
		return "/ajax/booking/main";
	}
	
	@ResponseBody
	@GetMapping("/ajax/booking/searchBooking")
	public Map<String, Object> searchBooking(
			@RequestParam("name") String name
			, @RequestParam("phoneNumber") String phoneNumber)
	{
		Booking booking = bookingService.searchBooking(name, phoneNumber);
		
		Map<String, Object> resultMap = new HashMap<>();
		
		if(booking == null)
		{
			resultMap.put("result", "fail");
		}
		else
		{
			// 객체 정보를 하나씩 저장하는 형태
			resultMap.put("name", booking.getName());
			resultMap.put("phoneNumber", booking.getPhoneNumber());
			resultMap.put("date", booking.getDate());
			resultMap.put("day", booking.getDay());
			resultMap.put("headcount", booking.getHeadcount());
			resultMap.put("state", booking.getState());		
			
			// 객체 전체를 저장하는 스타일
		}
		
		return resultMap;
	}
}
