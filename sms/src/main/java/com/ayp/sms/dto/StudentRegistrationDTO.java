package com.ayp.sms.dto;

import java.io.Serializable;

/**
 * 
 * @author rana
 *
 */

public class StudentRegistrationDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String fatherName;
	private String studentCNIC;
	private String fatherCNIC;
	private String contactNumber;
	private String address;
	private String imagePath;
	private Integer classId;
	private Integer classGroup;
	private String admissionDate;
	private String gender;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getStudentCNIC() {
		return studentCNIC;
	}
	public void setStudentCNIC(String studentCNIC) {
		this.studentCNIC = studentCNIC;
	}
	public String getFatherCNIC() {
		return fatherCNIC;
	}
	public void setFatherCNIC(String fatherCNIC) {
		this.fatherCNIC = fatherCNIC;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public String getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}
	public Integer getClassGroup() {
		return classGroup;
	}
	public void setClassGroup(Integer classGroup) {
		this.classGroup = classGroup;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

}
