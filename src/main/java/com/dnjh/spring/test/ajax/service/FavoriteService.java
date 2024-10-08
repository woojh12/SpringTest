package com.dnjh.spring.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnjh.spring.test.ajax.domain.Favorite;
import com.dnjh.spring.test.ajax.repository.FavoriteRepository;

@Service
public class FavoriteService {
	@Autowired
	private FavoriteRepository favoriteRepository;
	
	public List<Favorite> getFavoriteList()
	{
		List<Favorite> favoriteList = favoriteRepository.selectFavoriteList();
		
		return favoriteList;
	}
	
	public int addFavorite(String name, String url)
	{
		int count = favoriteRepository.insertFavorite(name, url);
		
		return count;
	}
	
	public boolean isDuplicateAddress(String url)
	{
		int count = favoriteRepository.selectCountByAddress(url);
		
		if(count == 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public int deleteFavorite(int id)
	{
		int count = favoriteRepository.deleteFavorite(id);
		
		return count;
	}
}
