package com.ayp.sms.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author rana
 *
 */

@Entity
@Table(name="subjects")
public class MainSubjects implements Serializable{

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
	@Column(nullable=false, name="name")
	private String name;
	
	@OneToMany(mappedBy="name")
	private List<ClassesSubjects> classList;

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

	public List<ClassesSubjects> getClassList() {
		return classList;
	}

	public void setClassList(List<ClassesSubjects> classList) {
		this.classList = classList;
	}

}
