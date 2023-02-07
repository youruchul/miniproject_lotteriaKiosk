package com.lotteria.kiosk.dto;

public class DrinkDTO {
	private Integer id;
	private String name;
	private String content;
	private Integer price;
	private String img;
	
	public DrinkDTO() {}
	
	public DrinkDTO(Integer id, String name, String content, Integer price, String img) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.price = price;
		this.img = img;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "DrinkDTO [id=" + id + ", name=" + name + ", content=" + content + ", price=" + price + ", img=" + img
				+ "]";
	}
	
}
