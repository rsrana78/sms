package com.ayp.sms.domain;
/**
 * @author rana
 * 
 */

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the testResult database table.
 * 
 */
@Entity
@Table(name="testResult")
public class TestResult implements Serializable {
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Basic
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, name="id")
	private Integer id;

	
	@Basic
	@Column(nullable=false, name="absent")
	private boolean absent;

	@Basic
	@Column(nullable=false, name="obtainedMarks")
	private Integer obtainedMarks;

	@Basic
	@Column(name="remarks")
	private String remarks;

	@ManyToOne
	@JoinColumn(name="test", nullable=false)
	private Test test;

	@ManyToOne
	@JoinColumn(name="student", nullable=false)
	private Student studentBean;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isAbsent() {
		return absent;
	}

	public void setAbsent(boolean absent) {
		this.absent = absent;
	}

	public Integer getObtainedMarks() {
		return obtainedMarks;
	}

	public void setObtainedMarks(Integer obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Student getStudentBean() {
		return studentBean;
	}

	public void setStudentBean(Student studentBean) {
		this.studentBean = studentBean;
	}

}