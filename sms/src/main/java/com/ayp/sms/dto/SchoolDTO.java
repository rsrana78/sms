package com.ayp.sms.dto;

import java.io.Serializable;

/**
 * 
 * @author rana
 *
 */

public class SchoolDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String schoolName;
	private String ownerName;
	private String ownerImagePath;
	private String address;
	private String principalName;
	private String principalImagePath;
	private String monogramPath;
	
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerImagePath() {
		return ownerImagePath;
	}
	public void setOwnerImagePath(String ownerImagePath) {
		this.ownerImagePath = ownerImagePath;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPrincipalName() {
		return principalName;
	}
	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}
	public String getPrincipalImagePath() {
		return principalImagePath;
	}
	public void setPrincipalImagePath(String principalImagePath) {
		this.principalImagePath = principalImagePath;
	}
	public String getMonogramPath() {
		return monogramPath;
	}
	public void setMonogramPath(String monogramPath) {
		this.monogramPath = monogramPath;
	}
}
