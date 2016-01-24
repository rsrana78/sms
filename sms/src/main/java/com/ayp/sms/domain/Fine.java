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
 * The persistent class for the fine database table.
 * 
 */
@Entity
@Table(name="fine")
public class Fine implements Serializable {
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
	@Column(nullable=false, name = "amount")
	private BigDecimal amount;

	@Basic
	@Column(nullable=false, name = "reason")
	private String reason;

	@Column(nullable=false)
	private boolean submitted;

	@ManyToOne
	@JoinColumn(name="student", nullable=false)
	private Student student;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public boolean isSubmitted() {
		return submitted;
	}

	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}