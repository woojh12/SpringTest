package com.dnjh.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dnjh.spring.test.mvc.domain.Realtor;
import com.dnjh.spring.test.mvc.service.RealtorService;

@Controller
public class RealtorController {
	@Autowired
	private RealtorService realtorService;
	
	@PostMapping("/mvc/realtor/create")
	public String createRealEstateByObject(
//					@RequestParam("office") String office
//					, @RequestParam("phoneNumber") String phoneNumber
//					, @RequestParam("address") String address
//					, @RequestParam("grade") String grade
					@ModelAttribute Realtor realtor		// 파라미터 대신 객체로 얻어오기
					, Model model)
	{
//		Realtor realtor = new Realtor();
//		realtor.setOffice(office);
//		realtor.setPhoneNumber(phoneNumber);
//		realtor.setAddress(address);
//		realtor.setGrade(grade);
		
		realtorService.addRealtorByObject(realtor);
		
		model.addAttribute("result", realtor);
		
		return "mvc/realtorInfo";
	}

	@GetMapping("/mvc/realtor/input")
	public String realEstateInput()
	{
		return "mvc/realtorInput";
	}
}
