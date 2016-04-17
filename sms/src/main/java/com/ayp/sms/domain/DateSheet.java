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
 * The persistent class for the dateSheet database table.
 * 
 */
@Entity
@Table(name="dateSheet")
public class DateSheet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Basic
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, name = "id")
	private Integer id;

	@OneToOne
	@JoinColumn(name="exam", nullable=false)
	private Exam exam;

	@ManyToOne
	@JoinColumn(name="class", nullable=false)
	private SchoolClasses schoolClass;

	@Basic
	@OneToMany(mappedBy="id")
	private List<DateSheetDetail> dateSheetDetails;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public SchoolClasses getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(SchoolClasses schoolClass) {
		this.schoolClass = schoolClass;
	}

	public List<DateSheetDetail> getDateSheetDetails() {
		return dateSheetDetails;
	}

	public void setDateSheetDetails(List<DateSheetDetail> dateSheetDetails) {
		this.dateSheetDetails = dateSheetDetails;
	}

}