package com.rest.content.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rest.content.model.vo.Cat;

@Mapper
public interface CatMapper {
	List<Cat> selectAll();
	List<Cat> selectByName(String name);
	Cat selectById(int id);
	int insertCat(Cat cat);
	Cat selectMostRecent();
	int updateCat(Cat requestCat);
	int deleteCat(int id);
}
