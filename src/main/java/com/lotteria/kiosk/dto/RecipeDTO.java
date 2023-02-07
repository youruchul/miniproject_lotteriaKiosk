package com.lotteria.kiosk.dto;

public class RecipeDTO {
	Integer id;
	Integer itemId;
	Integer foodId;
	String foodName;
	Integer foodCount;
	
	public RecipeDTO() {}
	
	public RecipeDTO(Integer itemId, Integer foodId, String foodName, Integer foodCount) {
		super();
		this.itemId = itemId;
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodCount = foodCount;
	}

	public RecipeDTO(Integer id, Integer itemId, Integer foodId, String foodName, Integer foodCount) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodCount = foodCount;
	}
	@Override
	public String toString() {
		return "RecipeDTO [id=" + id + ", itemId=" + itemId + ", foodId=" + foodId + ", foodName=" + foodName
				+ ", foodCount=" + foodCount + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getFoodId() {
		return foodId;
	}
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public Integer getFoodCount() {
		return foodCount;
	}
	public void setFoodCount(Integer foodCount) {
		this.foodCount = foodCount;
	}
	
	
}
