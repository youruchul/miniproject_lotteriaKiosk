package com.lotteria.kiosk.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lotteria.kiosk.dto.AdminDTO;
import com.lotteria.kiosk.dto.BurgerDTO;

@Repository
public class AdminRepository {

	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public int signup(AdminDTO dto) {
		return sessionTemplate.insert("admin.signup", dto);
	}
	
	public AdminDTO login(AdminDTO dto) {
		return sessionTemplate.selectOne("admin.login", dto);
	}
}
