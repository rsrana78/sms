package com.ayp.sms.dto;

import java.io.Serializable;

/**
 * 
 * @author rana
 *
 */

public class StudentFilterDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer classId;
	private String gender;
	private Integer grooupId;
	private boolean inActive;
	private boolean passout;
	private Integer schoolId;
	
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getGrooupId() {
		return grooupId;
	}
	public void setGrooupId(Integer grooupId) {
		this.grooupId = grooupId;
	}
	public boolean isInActive() {
		return inActive;
	}
	public void setInActive(boolean inActive) {
		this.inActive = inActive;
	}
	public boolean isPassout() {
		return passout;
	}
	public void setPassout(boolean passout) {
		this.passout = passout;
	}
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

}
