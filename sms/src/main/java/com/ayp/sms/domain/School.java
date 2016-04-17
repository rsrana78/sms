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
 * The persistent class for the school database table.
 * 
 */
@Entity
@Table(name="school")
public class School implements Serializable {
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
	@Column(nullable=false, name = "emailAddress")
	private String emailAddress;

	@Basic
	@Column(nullable=false, name = "entryDate")
	private Calendar entryDate;

	@Basic
	@Column(nullable=false, name = "monogram")
	private String monogram;

	@Basic
	@Column(nullable=false, name = "ownerName")
	private String ownerName;
	
	@Basic
	@Column(nullable=false, name = "ownerImg")
	private String ownerImage;

	@Basic
	@Column(nullable=false, name = "schoolName")
	private String schoolName;

	@Basic
	@Temporal(TemporalType.DATE)
	@Column(nullable=false, name = "startedDate")
	private Date startedDate;

	@OneToMany(mappedBy="school")
	private List<Campus> campus;
	
	@Basic
	@Column(name = "initials")
	private String schoolInitials;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Calendar getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Calendar entryDate) {
		this.entryDate = entryDate;
	}

	public String getMonogram() {
		return monogram;
	}

	public void setMonogram(String monogram) {
		this.monogram = monogram;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerImage() {
		return ownerImage;
	}

	public void setOwnerImage(String ownerImage) {
		this.ownerImage = ownerImage;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Date getStartedDate() {
		return startedDate;
	}

	public void setStartedDate(Date startedDate) {
		this.startedDate = startedDate;
	}

	public List<Campus> getCampus() {
		return campus;
	}

	public void setCampus(List<Campus> campus) {
		this.campus = campus;
	}

	public String getSchoolInitials() {
		return schoolInitials;
	}

	public void setSchoolInitials(String schoolInitials) {
		this.schoolInitials = schoolInitials;
	}

}