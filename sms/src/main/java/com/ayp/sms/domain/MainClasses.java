package com.ayp.sms.domain;
/**
 * 
 * @author rana
 * 
 */

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the class database table.
 * 
 */
@Entity
@Table(name="mainClasses")
public class MainClasses implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Basic
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, name = "id")
	private int id;

	@Basic
	@Column(nullable=false, length=45, name = "name")
	private String name;

	@OneToMany(mappedBy="id")
	private List<SchoolClasses> schoolClasses;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SchoolClasses> getSchoolClasses() {
		return schoolClasses;
	}

	public void setSchoolClasses(List<SchoolClasses> schoolClasses) {
		this.schoolClasses = schoolClasses;
	}
	
}