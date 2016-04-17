package com.ayp.sms.dto;

import java.io.Serializable;

/**
 * 
 * @author rana
 *
 */

public class SectionsDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String classIncharge;
	
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
	public String getClassIncharge() {
		return classIncharge;
	}
	public void setClassIncharge(String classIncharge) {
		this.classIncharge = classIncharge;
	}

}
