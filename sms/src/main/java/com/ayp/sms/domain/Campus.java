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
 * The persistent class for the campus database table.
 * 
 */
@Entity
@Table(name="campus")
public class Campus implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Basic
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, name = "id")
	private int id;

	@Basic
	@Column(nullable=false, name = "address")
	private String address;

	@Basic
	@Column(nullable=false, name = "campusName")
	private String campusName;

	@Basic
	@Column(nullable=false, name = "contact1")
	private String contact1;

	@Basic
	@Column(nullable=false, name = "contact2")
	private String contact2;

	@Basic
	@Column(nullable=false, name = "entryDate")
	private Calendar entryDate;

	@Basic
	@Column(nullable=false, name = "principalContact")
	private String principalContact;

	@Basic
	@Temporal(TemporalType.DATE)
	@Column(nullable=false, name = "startingDate")
	private Date startingDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="principal", nullable=false)
	private Employee principal;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="schoolId", nullable=false)
	private School school;
	
	@Basic
	@Column(name="monogram")
	private String monogram;

	@Basic(fetch = FetchType.LAZY)
	@OneToMany(mappedBy="campus")
	private List<Student> students;

	@Basic(fetch = FetchType.LAZY)
	@OneToMany(mappedBy="campus")
	private List<SchoolClass> schoolClasses;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCampusName() {
		return campusName;
	}

	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}

	public String getContact1() {
		return contact1;
	}

	public void setContact1(String contact1) {
		this.contact1 = contact1;
	}

	public String getContact2() {
		return contact2;
	}

	public void setContact2(String contact2) {
		this.contact2 = contact2;
	}

	public Calendar getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Calendar entryDate) {
		this.entryDate = entryDate;
	}

	public String getPrincipalContact() {
		return principalContact;
	}

	public void setPrincipalContact(String principalContact) {
		this.principalContact = principalContact;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public Employee getPrincipal() {
		return principal;
	}

	public void setPrincipal(Employee principal) {
		this.principal = principal;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public String getMonogram() {
		return monogram;
	}

	public void setMonogram(String monogram) {
		this.monogram = monogram;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<SchoolClass> getSchoolClasses() {
		return schoolClasses;
	}

	public void setSchoolClasses(List<SchoolClass> schoolClasses) {
		this.schoolClasses = schoolClasses;
	}

}