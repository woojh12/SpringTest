package com.dnjh.spring.test.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dnjh.spring.test.ajax.domain.Favorite;

@Mapper
public interface FavoriteRepository {
	public List<Favorite> selectFavorite();
}
