package com.ayp.sms.domain;
/**
 * 
 * @author rana
 * 
 */

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sections database table.
 * 
 */
@Entity
@Table(name="sections")
public class Sections implements Serializable {
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
	@Column(nullable=false, name="name")
	private String name;

	@Basic
	@Column(nullable=false, name = "sessionEnd")
	private boolean sessionEnd;

	@Basic
	@Column(nullable=false, name="sessionYear")
	private String sessionYear;

	@Basic
	@Temporal(TemporalType.DATE)
	@Column(nullable=false, name="startingDate")
	private Date startingDate;

	@OneToMany(mappedBy="id")
	private List<ClassDetail> classDetails;

	@ManyToOne
	@JoinColumn(name="incharge", nullable=false)
	private Employee employee;

	@OneToMany(mappedBy="section")
	private List<Student> students;

	@OneToMany(mappedBy="section")
	private List<ExamResult> examResults;

	@ManyToOne
	@JoinColumn(name="class", nullable=false)
	private SchoolClass schoolClass;

	@OneToMany(mappedBy="section")
	private List<Test> tests;

	@OneToMany(mappedBy="section")
	private List<TimeTable> timeTables;

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

	public boolean isSessionEnd() {
		return sessionEnd;
	}

	public void setSessionEnd(boolean sessionEnd) {
		this.sessionEnd = sessionEnd;
	}

	public String getSessionYear() {
		return sessionYear;
	}

	public void setSessionYear(String sessionYear) {
		this.sessionYear = sessionYear;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public List<ClassDetail> getClassDetails() {
		return classDetails;
	}

	public void setClassDetails(List<ClassDetail> classDetails) {
		this.classDetails = classDetails;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<ExamResult> getExamResults() {
		return examResults;
	}

	public void setExamResults(List<ExamResult> examResults) {
		this.examResults = examResults;
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

	public List<TimeTable> getTimeTables() {
		return timeTables;
	}

	public void setTimeTables(List<TimeTable> timeTables) {
		this.timeTables = timeTables;
	}

}