package com.lotteria.kiosk.dto;

public class BurgerDTO {
	private Integer id;
	private String name;
	private String content;
	private Integer price;
	private String singleImg;
	private String setImg;
	
	public BurgerDTO() {}

	public BurgerDTO(Integer id, String name, String content, Integer price, String singleImg, String setImg) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.price = price;
		this.singleImg = singleImg;
		this.setImg = setImg;
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

	public String getSingleImg() {
		return singleImg;
	}

	public void setSingleImg(String singleImg) {
		this.singleImg = singleImg;
	}

	public String getSetImg() {
		return setImg;
	}

	public void setSetImg(String setImg) {
		this.setImg = setImg;
	}

	@Override
	public String toString() {
		return "BurgerDTO [id=" + id + ", name=" + name + ", content=" + content + ", price=" + price + ", singleImg="
				+ singleImg + ", setImg=" + setImg + "]";
	}
	
}
