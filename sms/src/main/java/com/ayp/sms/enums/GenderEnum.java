package com.ayp.sms.enums;

public enum GenderEnum {
	MALE(1, "Male"),
	FEMALE(2, "Female");
	
	private Integer id;
	private String gender;
	
	GenderEnum(Integer id, String gender){
		this.id = id;
		this.gender = gender;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
