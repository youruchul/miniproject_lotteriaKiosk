package com.lotteria.kiosk.dto;

public class FoodDTO {
	Integer id;
	String name;
	Integer count;
	
	public FoodDTO(Integer id, String name, Integer count) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
	}
	public FoodDTO() {}
	
	@Override
	public String toString() {
		return "FoodDTO [id=" + id + ", name=" + name + ", count=" + count + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
