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

	public String getGender() {
		return gender;
	}
	
	public static String getGenderName(Integer id){
		if(id == GenderEnum.MALE.getId())
			return GenderEnum.MALE.getGender();
		else if(id == GenderEnum.FEMALE.getId())
			return GenderEnum.FEMALE.getGender();
		else
			return null;
	}
	
	public static Integer getGenderId(String name){
		if(name.equals(GenderEnum.MALE.getGender()))
			return GenderEnum.MALE.getId();
		else if(name.equals(GenderEnum.FEMALE.getGender()))
			return GenderEnum.FEMALE.getId();
		else
			return null;
	}
}
