package com.ayp.sms.enums;

public enum EmployeeTypeEnum {
	
	PRINCIPAL(1, "Principal"),
	TEACHER(2, "Teacher"),
	LECTURAR(3, "Lecturar"),
	PT(4, "PT Teacher"),
	GUARD(5, "Guard"),
	CLERK(6, "Clerk");
	
	Integer id;
	String name;
	
	EmployeeTypeEnum(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
}
