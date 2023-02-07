package com.lotteria.kiosk.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lotteria.kiosk.dto.CouponDTO;

@Repository
public class CouponRepository {
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public CouponDTO findOneByCode(String code) {
		return sessionTemplate.selectOne("kiosk.findOneByCode", code);
	}
}
