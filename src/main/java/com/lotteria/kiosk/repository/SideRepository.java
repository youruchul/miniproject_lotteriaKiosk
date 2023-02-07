package com.lotteria.kiosk.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lotteria.kiosk.dto.SideDTO;

@Repository
public class SideRepository {
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public List<SideDTO> findAllSideList() {
		return sessionTemplate.selectList("kiosk.findAllSideList");
	}
	
	public Integer addSide(SideDTO dto) {
		return sessionTemplate.insert("admin.addSide", dto);
	}
	
	public Integer deleteSide(Integer id) {
		return sessionTemplate.delete("admin.deleteSide", id);
	}
	public Integer updateSide(SideDTO dto) {
		return sessionTemplate.update("admin.updateSide", dto);
	}
	public SideDTO findOneSide(Integer id) {
		return sessionTemplate.selectOne("admin.findOneSide", id);
	}
}
