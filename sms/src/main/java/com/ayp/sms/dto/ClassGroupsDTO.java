package com.ayp.sms.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author rana
 *
 */

public class ClassGroupsDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private List<ClassGroupsDetailDTO> subjectList;
	
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
	public List<ClassGroupsDetailDTO> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(List<ClassGroupsDetailDTO> subjectList) {
		this.subjectList = subjectList;
	}

}
