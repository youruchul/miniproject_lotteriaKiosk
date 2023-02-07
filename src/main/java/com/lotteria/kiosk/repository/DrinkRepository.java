package com.lotteria.kiosk.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lotteria.kiosk.dto.DrinkDTO;

@Repository
public class DrinkRepository {
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public List<DrinkDTO> findAllDrinkList() {
		return sessionTemplate.selectList("kiosk.findAllDrinkList");
	}
	
	public Integer addDrink(DrinkDTO dto) {
		return sessionTemplate.insert("admin.addDrink", dto);
	}
	
	public Integer deleteDrink(Integer id) {
		return sessionTemplate.delete("admin.deleteDrink", id);
	}
	public Integer updateDrink(DrinkDTO dto) {
		return sessionTemplate.update("admin.updateDrink", dto);
	}
	public DrinkDTO findOneDrink(Integer id) {
		return sessionTemplate.selectOne("admin.findOneDrink", id);
	}
}
