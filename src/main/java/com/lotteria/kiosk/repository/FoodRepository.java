package com.lotteria.kiosk.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lotteria.kiosk.dto.FoodDTO;

@Repository
public class FoodRepository {
	 @Autowired
	 private SqlSessionTemplate sessionTemplate;
	 
	 public List<FoodDTO> findAllFoodList(){
		 return sessionTemplate.selectList("kiosk.findAllFoodList");
	 }
	 
	 public Integer addFood(FoodDTO dto) {
		 return sessionTemplate.insert("admin.addFood", dto);
	 }
	 public Integer updateFood(FoodDTO dto) {
		 return sessionTemplate.update("admin.updateFood", dto);
	 }
	 public FoodDTO findOneFood(Integer id) {
		 return sessionTemplate.selectOne("admin.findOneFood", id);
	 }
	 public Integer updateFoodCount(FoodDTO dto) {
		 return sessionTemplate.update("kiosk.updateFoodCount", dto);
	 }
}
