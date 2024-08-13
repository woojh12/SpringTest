package com.dnjh.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.dnjh.spring.test.mvc.domain.Seller;
import com.dnjh.spring.test.mvc.service.SellerService;

@Controller
@RequestMapping("/mvc/seller")
public class SellerController {
	@Autowired
	private SellerService sellerService;
	
	// RequestParam은 html에서 넘어오는 파라미터 명과 동일해야함
	// 데이터 저장 과정을 진행할 페이지
	@PostMapping("/create")
	public String createSeller(
			@RequestParam("nickName") String nickName
			, @RequestParam("temperature") double temperature
			, @RequestParam("profile") String profileImage)
	{
		int count = sellerService.addSeller(nickName, temperature, profileImage);
		
		// Redirect설정	
		return "redirect:/mvc/seller/info";
	}
	
	@GetMapping("/input")
	public String sellerInput(Model model)
	{
		return "mvc/sellerInput";
	}
	
	@GetMapping("/info")
	public String sellerInfo(
			@RequestParam(value="id", required=false) Integer id
			,Model model)
	{
		Seller seller = null;
		// id가 전달이 안되면 최근 판매자 조회
		if(id == null)
		{
			seller = sellerService.getLastSeller();
		}
		// id가 전달이 되면 매치된 판매자 조회
		else
		{
			seller = sellerService.getSeller(id);			
		}
		model.addAttribute("seller", seller);
		
		return "mvc/sellerOutput";
	}
	
}
