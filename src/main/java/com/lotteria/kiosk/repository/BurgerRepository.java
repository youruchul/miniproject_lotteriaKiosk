package com.lotteria.kiosk.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lotteria.kiosk.dto.BurgerDTO;

@Repository
public class BurgerRepository {
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public List<BurgerDTO> findAllBurgerList() {
		return sessionTemplate.selectList("kiosk.findAllBurgerList");
	}
	
	public BurgerDTO findOneById(Integer burgerId) {
		return sessionTemplate.selectOne("kiosk.findOneById", burgerId);
	}
	public Integer addBurger(BurgerDTO dto) {
		return sessionTemplate.insert("admin.addBurger", dto);
	}
	
	public Integer deleteBurger(Integer id) {
		return sessionTemplate.delete("admin.deleteBurger", id);
	}
	public Integer updateBurger(BurgerDTO dto) {
		return sessionTemplate.update("admin.updateBurger", dto);
	}
	public BurgerDTO findOneBurger(Integer id) {
		return sessionTemplate.selectOne("admin.findOneBurger", id);
	}
}
