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
 * The persistent class for the attendance database table.
 * 
 */
@Entity
@Table(name="attendance")
public class Attendance implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Basic
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, name = "id")
	private Integer attendenceId;

	@Basic
	@Temporal(TemporalType.DATE)
	@Column(nullable=false, name = "date")
	private Calendar date;
	
	@Basic
	@Column(nullable=false, name = "day")
	private Integer day;

	@Basic
	@Column(nullable=false, name = "isHoliday")
	private boolean holiday;

	@Basic
	@Column(nullable=false, name = "month")
	private Integer month;

	@Column(nullable=false, name = "year")
	private Integer year;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "attendenceId")
	private List<AttendanceDetailEmployee> attendanceDetailEmployees;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "attendenceId")
	private List<AttendanceDetailStudent> attendanceDetailStudent;

	public Integer getAttendenceId() {
		return attendenceId;
	}

	public void setAttendenceId(Integer attendenceId) {
		this.attendenceId = attendenceId;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public boolean isHoliday() {
		return holiday;
	}

	public void setHoliday(boolean holiday) {
		this.holiday = holiday;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public List<AttendanceDetailEmployee> getAttendanceDetailEmployees() {
		return attendanceDetailEmployees;
	}

	public void setAttendanceDetailEmployees(
			List<AttendanceDetailEmployee> attendanceDetailEmployees) {
		this.attendanceDetailEmployees = attendanceDetailEmployees;
	}

	public List<AttendanceDetailStudent> getAttendanceDetailStudent() {
		return attendanceDetailStudent;
	}

	public void setAttendanceDetailStudent(
			List<AttendanceDetailStudent> attendanceDetailStudent) {
		this.attendanceDetailStudent = attendanceDetailStudent;
	}

}