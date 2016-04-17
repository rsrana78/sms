package com.ayp.sms.domain;
/**
 * 
 * @author rana
 * 
 */

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the timeTableDetail database table.
 * 
 */
@Entity
@Table(name="timeTableDetail")
public class TimeTableDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Basic
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, name="id")
	private Integer id;

	@Basic
	@Column(nullable=false, name="lectureName")
	private String lectureName;

	@ManyToOne
	@JoinColumn(name="timeTable", nullable=false)
	private TimeTable timeTable;

	@ManyToOne
	@JoinColumn(name="subject", nullable=false)
	private ClassesSubjects subject;

	@ManyToOne
	@JoinColumn(name="teacher", nullable=false)
	private Employee employee;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public TimeTable getTimeTable() {
		return timeTable;
	}

	public void setTimeTable(TimeTable timeTable) {
		this.timeTable = timeTable;
	}

	public ClassesSubjects getSubject() {
		return subject;
	}

	public void setSubject(ClassesSubjects subject) {
		this.subject = subject;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}