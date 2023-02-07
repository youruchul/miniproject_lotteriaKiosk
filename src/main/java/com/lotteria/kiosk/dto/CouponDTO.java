package com.lotteria.kiosk.dto;

public class CouponDTO {
	private Integer id;
	private String name;
	private Integer percent;
	private String code;
	
	public CouponDTO() {}
	
	public CouponDTO(Integer id, String name, Integer percent, String code) {
		this.id = id;
		this.name = name;
		this.percent = percent;
		this.code = code;
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

	public Integer getPercent() {
		return percent;
	}

	public void setPercent(Integer percent) {
		this.percent = percent;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "CouponDTO [id=" + id + ", name=" + name + ", percent=" + percent + ", code=" + code + "]";
	}
	
}
