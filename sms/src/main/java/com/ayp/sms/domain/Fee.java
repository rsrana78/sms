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
 * The persistent class for the fee database table.
 * 
 */
@Entity
@Table(name="fee")
public class Fee implements Serializable {
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
	@Column(nullable=false, name = "fee")
	private BigDecimal fee;

	@ManyToOne
	@JoinColumn(name="class", nullable=false)
	private SchoolClasses schoolClass;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public SchoolClasses getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(SchoolClasses schoolClass) {
		this.schoolClass = schoolClass;
	}

}