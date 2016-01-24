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
 * The persistent class for the salary database table.
 * 
 */
@Entity
@Table(name="salary")
public class Salary implements Serializable {
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

	@Basic
	@Column(nullable=false, name = "month")
	private Integer month;

	@Basic
	@Column(nullable=false, name = "year")
	private String year;

	@Basic
	@OneToMany(mappedBy="id")
	private List<SalaryDetail> salaryDetails;

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

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<SalaryDetail> getSalaryDetails() {
		return salaryDetails;
	}

	public void setSalaryDetails(List<SalaryDetail> salaryDetails) {
		this.salaryDetails = salaryDetails;
	}

}