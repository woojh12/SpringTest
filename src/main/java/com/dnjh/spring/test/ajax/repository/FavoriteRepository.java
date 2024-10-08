package com.dnjh.spring.test.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dnjh.spring.test.ajax.domain.Favorite;

@Mapper
public interface FavoriteRepository {
	public List<Favorite> selectFavoriteList();
	
	public int insertFavorite(
			@Param("name") String name
			, @Param("url") String url);
	
	public int selectCountByAddress(@Param("url") String url);
	
	public int deleteFavorite(@Param("id") int id);
}
