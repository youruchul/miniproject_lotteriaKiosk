package com.lotteria.kiosk.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lotteria.kiosk.dto.ChoiceDTO;

@Repository
public class ChoiceRepository {
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public Integer choiceFood(ChoiceDTO dto) {
		return sessionTemplate.insert("kiosk.choiceFood", dto);
	}
	
	public List<ChoiceDTO> findAllChoiceList() {
		return sessionTemplate.selectList("kiosk.findAllChoiceList");
	}
	
	public Integer deleteChoice() {
		return sessionTemplate.delete("kiosk.deleteChoice");
	}
}
