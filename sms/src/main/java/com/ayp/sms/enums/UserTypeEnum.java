package com.ayp.sms.enums;
/**
 * 
 * @author rana
 *
 */

public enum UserTypeEnum {
	
	STUDENT(1, "student"),
	EMPLOYEE(2, "employee"),
	PRINCIPAL(3, "principal"),
	ADMIN(4, "admin");
	
	private Integer id;
	private String type;
	
	private UserTypeEnum(Integer id, String type) {
		this.id=id;
		this.type=type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
