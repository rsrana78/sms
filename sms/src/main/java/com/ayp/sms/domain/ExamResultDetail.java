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
 * The persistent class for the examResultDetail database table.
 * 
 */
@Entity
@Table(name="examResultDetail")
public class ExamResultDetail implements Serializable {
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
	@Column(nullable=false, name = "totalMarks")
	private Integer totalMarks;

	@ManyToOne
	@JoinColumn(name="examResult", nullable=false)
	private ExamResult examResult;

	@ManyToOne
	@JoinColumn(name="subject", nullable=false)
	private ClassesSubjects subject;

	@ManyToOne
	@JoinColumn(name="subjectTeacher", nullable=false)
	private Employee employee;

	@Basic
	@OneToMany(mappedBy="id")
	private List<ExamResultDetailMark> examResultDetailMarks;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = totalMarks;
	}

	public ExamResult getExamResult() {
		return examResult;
	}

	public void setExamResult(ExamResult examResult) {
		this.examResult = examResult;
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

	public List<ExamResultDetailMark> getExamResultDetailMarks() {
		return examResultDetailMarks;
	}

	public void setExamResultDetailMarks(
			List<ExamResultDetailMark> examResultDetailMarks) {
		this.examResultDetailMarks = examResultDetailMarks;
	}

}