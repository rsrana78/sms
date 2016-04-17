package com.ayp.sms.domain;
/**
 * 
 * @author rana
 * 
 */

import java.io.Serializable;

import javax.persistence.*;

import java.util.Calendar;


/**
 * The persistent class for the dateSheetDetail database table.
 * 
 */
@Entity
@Table(name="dateSheetDetail")
public class DateSheetDetail implements Serializable {
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
	@Column(nullable=false, name = "date")
	private Calendar date;

	@ManyToOne
	@JoinColumn(name="dateSheet", nullable=false)
	private DateSheet dateSheet;

	@ManyToOne
	@JoinColumn(name="subject", nullable=false)
	private ClassesSubjects subjectBean;

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

	public DateSheet getDateSheet() {
		return dateSheet;
	}

	public void setDateSheet(DateSheet dateSheet) {
		this.dateSheet = dateSheet;
	}

	public ClassesSubjects getSubjectBean() {
		return subjectBean;
	}

	public void setSubjectBean(ClassesSubjects subjectBean) {
		this.subjectBean = subjectBean;
	}

}