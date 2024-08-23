package com.dnjh.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dnjh.spring.test.ajax.domain.Favorite;
import com.dnjh.spring.test.ajax.service.FavoriteService;

@Controller
public class FavoriteController {
	@Autowired
	private FavoriteService favoriteService;
	
	@GetMapping("/ajax/favorite/info")
	public String favoriteList(Model model)
	{
		List<Favorite> favoriteList = favoriteService.getFavoriteList();
		
		model.addAttribute("favoriteList", favoriteList);
		
		return "ajax/favorite/list";
	}
	
	@ResponseBody
	@PostMapping("/ajax/favorite/create")
	public Map<String, String> createFavorite(
			@RequestParam("name") String name
			, @RequestParam("url") String url)
	{
		int count = favoriteService.addFavorite(name, url);
		
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
	
	@GetMapping("/ajax/favorite/input")
	public String favoriteInput()
	{
		return "ajax/favorite/input";
	}
}
