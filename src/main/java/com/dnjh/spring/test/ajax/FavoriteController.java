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
	
	@ResponseBody
	@GetMapping("/ajax/favorite/duplicate")
	public Map<String, Boolean> isduplicateUrl(@RequestParam("url") String url)
	{
		boolean isDuplicate = favoriteService.isDuplicateAddress(url);
		Map<String, Boolean> resultMap = new HashMap<>();
		
		if(isDuplicate)
		{
			resultMap.put("isDuplicate", true);
		}
		else
		{
			resultMap.put("isDuplicate", false);
		}
		
		return resultMap;
	}
	
	@ResponseBody
	@GetMapping("/ajax/favorite/delete")
	public Map<String, String> deleteFavorite(@RequestParam("id") int id)
	{
		int count = favoriteService.deleteFavorite(id);
		
		// {"result:""success"}
		// {"result":"fail"}
		
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
}
