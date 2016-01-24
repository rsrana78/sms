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
 * The persistent class for the schoolClasses database table.
 * 
 */
@Entity
@Table(name="schoolClasses")
public class SchoolClass implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Basic
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, name = "id")
	private Integer id;

	@Basic
	@Column(nullable=false, name = "active")
	private boolean active;

	@OneToMany(mappedBy="id")
	private List<DateSheet> dateSheets;

	@ManyToOne
	@JoinColumn(name="school", nullable=false)
	private Campus campus;

	@ManyToOne
	@JoinColumn(name="class", nullable=false)
	private SchoolClasses classes;

	@OneToMany(mappedBy="id")
	private List<Sections> sections;

	@OneToMany(mappedBy="id")
	private List<StudentClassGroup> studentClassGroups;

	@OneToMany(mappedBy="schoolClass")
	private List<Subject> subjects;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<DateSheet> getDateSheets() {
		return dateSheets;
	}

	public void setDateSheets(List<DateSheet> dateSheets) {
		this.dateSheets = dateSheets;
	}

	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

	public SchoolClasses getClasses() {
		return classes;
	}

	public void setClasses(SchoolClasses classes) {
		this.classes = classes;
	}

	public List<Sections> getSections() {
		return sections;
	}

	public void setSections(List<Sections> sections) {
		this.sections = sections;
	}

	public List<StudentClassGroup> getStudentClassGroups() {
		return studentClassGroups;
	}

	public void setStudentClassGroups(List<StudentClassGroup> studentClassGroups) {
		this.studentClassGroups = studentClassGroups;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

}