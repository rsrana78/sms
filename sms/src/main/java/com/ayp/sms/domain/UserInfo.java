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

	@ManyToOne
	@JoinColumn(name="student")
	private Student student;

	@Basic
	@Column(nullable=false, name="userName")
	private String userName;

	@ManyToOne
	@JoinColumn(name="employee")
	private Employee employee;
	
	@Basic
	@Column(name="active")
	private boolean active;

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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}