package com.dnjh.spring.test.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dnjh.spring.test.ajax.domain.Favorite;
import com.dnjh.spring.test.ajax.service.FavoriteService;

@Controller
public class FavoriteController {
	@Autowired
	private FavoriteService favoriteService;
	
	@GetMapping("/ajax/test01/info")
	public String favoriteInfo(Model model)
	{
		List<Favorite> favoriteList = favoriteService.getFavorite();
		
		model.addAttribute("favoriteList", favoriteList);
		
		return "ajax/favoriteInfo";
	}
}
