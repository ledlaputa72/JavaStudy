package com.mgr.sawon.vo;

import java.sql.Date;

public class TelInfoVO {

	private int id;
	private String name;
	private String tel;
	//private String d;
	//private Date d;
	
	//»ý¼ºÀÚ 
	public TelInfoVO() {
		
	}
	
	public TelInfoVO(int id, String name, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
	}	

	//getter, setter 
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
