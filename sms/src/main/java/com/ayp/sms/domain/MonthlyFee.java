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
 * The persistent class for the monthlyFee database table.
 * 
 */
@Entity
@Table(name="monthlyFee")
public class MonthlyFee implements Serializable {
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
	@Column(nullable=false, name = "entryDate")
	private Calendar entryDate;

	@Basic
	@Temporal(TemporalType.DATE)
	@Column(nullable=false, name = "lastDateOfFeeSubmit")
	private Calendar lastDateOfFeeSubmit;

	@Basic
	@Column(nullable=false, name = "month")
	private String month;

	@Basic
	@Column(nullable=false, name = "year")
	private String year;

	@Basic
	@OneToMany(mappedBy="id")
	private List<MonthlyFeeDetail> monthlyFeeDetails;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Calendar entryDate) {
		this.entryDate = entryDate;
	}

	public Calendar getLastDateOfFeeSubmit() {
		return lastDateOfFeeSubmit;
	}

	public void setLastDateOfFeeSubmit(Calendar lastDateOfFeeSubmit) {
		this.lastDateOfFeeSubmit = lastDateOfFeeSubmit;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<MonthlyFeeDetail> getMonthlyFeeDetails() {
		return monthlyFeeDetails;
	}

	public void setMonthlyFeeDetails(List<MonthlyFeeDetail> monthlyFeeDetails) {
		this.monthlyFeeDetails = monthlyFeeDetails;
	}

}