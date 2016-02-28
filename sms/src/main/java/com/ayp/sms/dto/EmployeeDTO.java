package com.ayp.sms.dto;

import java.io.Serializable;
import java.util.List;

import com.ayp.sms.domain.EmployeeType;
import com.ayp.sms.domain.Qualification;

/**
 * 
 * @author rana
 *
 */

public class EmployeeDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String fatherName;
	private String cnic;
	private String phone;
	private String email;
	private String salary;
	private Integer type;
	private Integer qualification;
	private String address;
	private List<EmployeeType> employeeTypeList;
	private List<Qualification> qualificationList;
	
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
	public String getCnic() {
		return cnic;
	}
	public void setCnic(String cnic) {
		this.cnic = cnic;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getQualification() {
		return qualification;
	}
	public void setQualification(Integer qualification) {
		this.qualification = qualification;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<EmployeeType> getEmployeeTypeList() {
		return employeeTypeList;
	}
	public void setEmployeeTypeList(List<EmployeeType> employeeTypeList) {
		this.employeeTypeList = employeeTypeList;
	}
	public List<Qualification> getQualificationList() {
		return qualificationList;
	}
	public void setQualificationList(List<Qualification> qualificationList) {
		this.qualificationList = qualificationList;
	}

}