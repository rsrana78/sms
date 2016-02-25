package com.ayp.sms.domain;
/**
 * 
 * @author rana
 * 
 */

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the monthlyFeeDetail database table.
 * 
 */
@Entity
@Table(name="monthlyFeeDetail")
public class MonthlyFeeDetail implements Serializable {
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
	@Column(nullable=false, name = "completePaid")
	private boolean completePaid;

	@Basic
	@Column(nullable=false, name = "depositedFee")
	private BigDecimal depositedFee;

	@Basic
	@Column(nullable=false, name = "late")
	private boolean late;

	@Basic
	@Column(name = "message")
	private String message;

	@Basic
	@Column(nullable=false, name = "totalDays")
	private String totalDays;

	@Basic
	@Column(nullable=false, name = "totalFee")
	private BigDecimal totalFee;

	@ManyToOne
	@JoinColumn(name="monthlyFee", nullable=false)
	private MonthlyFee monthlyFee;

	@ManyToOne
	@JoinColumn(name="student", nullable=false)
	private Student student;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isCompletePaid() {
		return completePaid;
	}

	public void setCompletePaid(boolean completePaid) {
		this.completePaid = completePaid;
	}

	public BigDecimal getDepositedFee() {
		return depositedFee;
	}

	public void setDepositedFee(BigDecimal depositedFee) {
		this.depositedFee = depositedFee;
	}

	public boolean isLate() {
		return late;
	}

	public void setLate(boolean late) {
		this.late = late;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(String totalDays) {
		this.totalDays = totalDays;
	}

	public BigDecimal getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(BigDecimal totalFee) {
		this.totalFee = totalFee;
	}

	public MonthlyFee getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(MonthlyFee monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


}