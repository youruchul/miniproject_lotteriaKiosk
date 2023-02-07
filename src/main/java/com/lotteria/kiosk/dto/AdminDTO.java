package com.lotteria.kiosk.dto;

public class AdminDTO {
	private Integer id;
	private String adminId;
	private String adminPW;
	private String name;
	
	public AdminDTO(){};
	
	public AdminDTO(Integer id, String adminId, String adminPW, String name) {
		super();
		this.id = id;
		this.adminId = adminId;
		this.adminPW = adminPW;
		this.name = name;
	}
	@Override
	public String toString() {
		return "AdminDTO [id=" + id + ", adminId=" + adminId + ", adminPW=" + adminPW + ", name=" + name + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPW() {
		return adminPW;
	}
	public void setAdminPW(String adminPW) {
		this.adminPW = adminPW;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
