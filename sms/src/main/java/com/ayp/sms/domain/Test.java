package com.ayp.sms.domain;
/**
 * 
 * @author rana
 * 
 */

import java.io.Serializable;

import javax.persistence.*;

import java.util.Calendar;
import java.util.List;


/**
 * The persistent class for the tests database table.
 * 
 */
@Entity
@Table(name="tests")
public class Test implements Serializable {
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
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Calendar date;

	@Basic
	@Column(nullable=false, name="resultAnnounced")
	private boolean resultAnnounced;

	@Basic
	@Column(nullable=false, name="totalMarks")
	private int totalMarks;

	@OneToMany(mappedBy="id")
	private List<TestResult> testResults;

	@ManyToOne
	@JoinColumn(name="class", nullable=false)
	private Sections section;

	@ManyToOne
	@JoinColumn(name="subject", nullable=false)
	private ClassesSubjects subject;

	@ManyToOne
	@JoinColumn(name="teacher", nullable=false)
	private Employee employee;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public boolean isResultAnnounced() {
		return resultAnnounced;
	}

	public void setResultAnnounced(boolean resultAnnounced) {
		this.resultAnnounced = resultAnnounced;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public List<TestResult> getTestResults() {
		return testResults;
	}

	public void setTestResults(List<TestResult> testResults) {
		this.testResults = testResults;
	}

	public Sections getSection() {
		return section;
	}

	public void setSection(Sections section) {
		this.section = section;
	}

	public ClassesSubjects getSubject() {
		return subject;
	}

	public void setSubject(ClassesSubjects subject) {
		this.subject = subject;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}