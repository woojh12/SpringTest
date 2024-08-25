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
import org.springframework.web.bind.annotation.PostMapping;
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
}
