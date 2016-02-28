package com.ayp.sms.domain;
/**
 * 
 * @author rana
 * 
 */

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the usersLogin database table.
 * 
 */
@Entity
@Table(name="usersLogin")
public class UserInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Basic
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, name="id")
	private Integer id;

	@Basic
	@Column(nullable=false, name="email")
	private String email;

	@Basic
	@Column(nullable=false, name="fullName")
	private String fullName;

	@Basic
	@Column(nullable=false, name="password")
	private String password;

	@Basic
	@Column(name="school")
	private Integer school;

	@Basic
	@Column(nullable=false, name="schoolCampus")
	private Integer schoolCampus;

	@Basic
	@Column(name="student")
	private boolean student;

	@Basic
	@Column(name="superUser")
	private boolean superUser;

	@Basic
	@Column(nullable=false, name="userName")
	private String userName;

	@Basic
	@Column(name="employee")
	private Integer employee;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getSchool() {
		return school;
	}

	public void setSchool(Integer school) {
		this.school = school;
	}

	public Integer getSchoolCampus() {
		return schoolCampus;
	}

	public void setSchoolCampus(Integer schoolCampus) {
		this.schoolCampus = schoolCampus;
	}

	public boolean isStudent() {
		return student;
	}

	public void setStudent(boolean student) {
		this.student = student;
	}

	public boolean isSuperUser() {
		return superUser;
	}

	public void setSuperUser(boolean superUser) {
		this.superUser = superUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getEmployee() {
		return employee;
	}

	public void setEmployee(Integer employee) {
		this.employee = employee;
	}

}