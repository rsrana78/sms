package com.ayp.sms.domain;
/**
 * 
 * @author rana
 * 
 */

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the examResultDetailMarks database table.
 * 
 */
@Entity
@Table(name="examResultDetailMarks")
public class ExamResultDetailMark implements Serializable {
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
	@Column(nullable=false, name = "absent")
	private boolean absent;

	@Basic
	@Column(nullable=false, name = "marksObtained")
	private Integer marksObtained;

	@Basic
	@Column(name = "remarks")
	private String remarks;

	@ManyToOne
	@JoinColumn(name="examResultDetail", nullable=false)
	private ExamResultDetail examResultDetail;

	@ManyToOne
	@JoinColumn(name="student", nullable=false)
	private Student student;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isAbsent() {
		return absent;
	}

	public void setAbsent(boolean absent) {
		this.absent = absent;
	}

	public Integer getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(Integer marksObtained) {
		this.marksObtained = marksObtained;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public ExamResultDetail getExamResultDetail() {
		return examResultDetail;
	}

	public void setExamResultDetail(ExamResultDetail examResultDetail) {
		this.examResultDetail = examResultDetail;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}