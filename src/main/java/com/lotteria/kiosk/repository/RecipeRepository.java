package com.lotteria.kiosk.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lotteria.kiosk.dto.RecipeDTO;

@Repository
public class RecipeRepository {
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public Integer addRecipe(RecipeDTO dto) {
		return sessionTemplate.insert("admin.addRecipe", dto);
	}
	public List<RecipeDTO> findListByitemId(Integer itemId) {
		return sessionTemplate.selectList("kiosk.findListByitemId", itemId);
	}
}
