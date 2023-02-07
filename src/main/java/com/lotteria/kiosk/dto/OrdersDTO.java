package com.lotteria.kiosk.dto;

public class OrdersDTO {
	private Integer id;
	private Integer totalCount;
	private Integer totalPrice;
	
	public OrdersDTO() {}
	
	public OrdersDTO(Integer id, Integer totalCount, Integer totalPrice) {
		this.id = id;
		this.totalCount = totalCount;
		this.totalPrice = totalPrice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "OrdersDTO [id=" + id + ", totalCount=" + totalCount + ", totalPrice=" + totalPrice + "]";
	}
}
