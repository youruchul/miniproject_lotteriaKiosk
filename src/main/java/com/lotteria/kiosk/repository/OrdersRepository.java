package com.lotteria.kiosk.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lotteria.kiosk.dto.OrdersDTO;

@Repository
public class OrdersRepository {
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public OrdersDTO findLastOrderNumber() {
		return sessionTemplate.selectOne("kiosk.findLastOrderNumber");
	}
	
	public Integer insertOrder(OrdersDTO dto) {
		return sessionTemplate.insert("kiosk.insertOrder", dto);
	}
}
