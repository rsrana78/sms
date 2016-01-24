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
 * The persistent class for the examResult database table.
 * 
 */
@Entity
@Table(name="examResult")
public class ExamResult implements Serializable {
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
	@Column(nullable=false, name = "first")
	private int firstPosition;

	@Basic
	@Column(nullable=false, name = "second")
	private int secondPosition;

	@Basic
	@Column(nullable=false, name = "third")
	private int third;

	@ManyToOne
	@JoinColumn(name="exam", nullable=false)
	private Exam exam;

	@ManyToOne
	@JoinColumn(name="class", nullable=false)
	private Sections section;

	@OneToMany(mappedBy="id")
	private List<ExamResultDetail> examResultDetails;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getFirstPosition() {
		return firstPosition;
	}

	public void setFirstPosition(int firstPosition) {
		this.firstPosition = firstPosition;
	}

	public int getSecondPosition() {
		return secondPosition;
	}

	public void setSecondPosition(int secondPosition) {
		this.secondPosition = secondPosition;
	}

	public int getThird() {
		return third;
	}

	public void setThird(int third) {
		this.third = third;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Sections getSection() {
		return section;
	}

	public void setSection(Sections section) {
		this.section = section;
	}

	public List<ExamResultDetail> getExamResultDetails() {
		return examResultDetails;
	}

	public void setExamResultDetails(List<ExamResultDetail> examResultDetails) {
		this.examResultDetails = examResultDetails;
	}

}