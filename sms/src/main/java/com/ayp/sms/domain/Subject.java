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
 * The persistent class for the subjects database table.
 * 
 */
@Entity
@Table(name="subjects")
public class Subject implements Serializable {
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
	@Column(nullable=false, name="active")
	private boolean active;

	@Basic
	@Column(nullable=false, name = "compulsory")
	private boolean compulsory;

	@Basic
	@Column(nullable=false, name="elective")
	private boolean elective;

	@Basic
	@Column(nullable=false, name="name")
	private String name;

	@Basic
	@OneToMany(mappedBy="id")
	private List<DateSheetDetail> dateSheetDetails;

	@Basic
	@OneToMany(mappedBy="id")
	private List<ExamResultDetail> examResultDetails;

	@Basic
	@OneToMany(mappedBy="id")
	private List<StudentClassGroupDetail> studentClassGroupDetails;

	@ManyToOne
	@JoinColumn(name="class", nullable=false)
	private SchoolClass schoolClass;

	@OneToMany(mappedBy="id")
	private List<Test> tests;

	@OneToMany(mappedBy="id")
	private List<TimeTableDetail> timeTableDetails;

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

	public boolean isCompulsory() {
		return compulsory;
	}

	public void setCompulsory(boolean compulsory) {
		this.compulsory = compulsory;
	}

	public boolean isElective() {
		return elective;
	}

	public void setElective(boolean elective) {
		this.elective = elective;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DateSheetDetail> getDateSheetDetails() {
		return dateSheetDetails;
	}

	public void setDateSheetDetails(List<DateSheetDetail> dateSheetDetails) {
		this.dateSheetDetails = dateSheetDetails;
	}

	public List<ExamResultDetail> getExamResultDetails() {
		return examResultDetails;
	}

	public void setExamResultDetails(List<ExamResultDetail> examResultDetails) {
		this.examResultDetails = examResultDetails;
	}

	public List<StudentClassGroupDetail> getStudentClassGroupDetails() {
		return studentClassGroupDetails;
	}

	public void setStudentClassGroupDetails(
			List<StudentClassGroupDetail> studentClassGroupDetails) {
		this.studentClassGroupDetails = studentClassGroupDetails;
	}

	public SchoolClass getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}

	public List<Test> getTests() {
		return tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public List<TimeTableDetail> getTimeTableDetails() {
		return timeTableDetails;
	}

	public void setTimeTableDetails(List<TimeTableDetail> timeTableDetails) {
		this.timeTableDetails = timeTableDetails;
	}
}