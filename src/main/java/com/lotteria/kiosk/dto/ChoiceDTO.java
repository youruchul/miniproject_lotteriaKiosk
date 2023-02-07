package com.lotteria.kiosk.dto;

public class ChoiceDTO {
	private Integer id;
	private Integer categoryId;
	private Integer itemId;
	private Integer count;
	
	public ChoiceDTO() {}
	
	public ChoiceDTO(Integer id, Integer categoryId, Integer itemId, Integer count) {
		this.id = id;
		this.categoryId = categoryId;
		this.itemId = itemId;
		this.count = count;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "ChoiceDTO [id=" + id + ", categoryId=" + categoryId + ", itemId=" + itemId + ", count=" + count + "]";
	}
	
}
