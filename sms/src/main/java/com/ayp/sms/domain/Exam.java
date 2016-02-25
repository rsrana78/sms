package com.ayp.sms.domain;
/**
 * 
 * @author rana
 * 
 */

import java.io.Serializable;

import javax.persistence.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the exams database table.
 * 
 */
@Entity
@Table(name="exams")
public class Exam implements Serializable {
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
	@Temporal(TemporalType.DATE)
	@Column(nullable=false, name = "endDate")
	private Calendar endDate;

	@Basic
	@Column(nullable=false, name = "examEnd")
	private boolean examEnd;

	@Basic
	@Column(nullable=false, name = "examName")
	private String examName;

	@Basic
	@Column(nullable=false, name = "resultAnnounced")
	private boolean resultAnnounced;

	@Basic
	@Temporal(TemporalType.DATE)
	@Column(nullable=false, name = "startDate")
	private Date startDate;

	@Basic
	@Column(nullable=false, name = "year")
	private String year;

	@Basic
	@OneToMany(mappedBy="id")
	private List<DateSheet> dateSheets;

	@Basic
	@OneToMany(mappedBy="id")
	private List<ExamResult> examResults;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public boolean isExamEnd() {
		return examEnd;
	}

	public void setExamEnd(boolean examEnd) {
		this.examEnd = examEnd;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public boolean isResultAnnounced() {
		return resultAnnounced;
	}

	public void setResultAnnounced(boolean resultAnnounced) {
		this.resultAnnounced = resultAnnounced;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<DateSheet> getDateSheets() {
		return dateSheets;
	}

	public void setDateSheets(List<DateSheet> dateSheets) {
		this.dateSheets = dateSheets;
	}

	public List<ExamResult> getExamResults() {
		return examResults;
	}

	public void setExamResults(List<ExamResult> examResults) {
		this.examResults = examResults;
	}
	
}