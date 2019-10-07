package com.mgr.sawon.vo;

public class TelInfoVO {
	
	private int id;
	private String name;
	private String tel;
	
	// 디폴트 생성자
	public TelInfoVO() {
		super();
	}

	// 생성자
	public TelInfoVO(int id, String name, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
