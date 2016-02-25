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
 * The persistent class for the attendanceDetailStudent database table.
 * 
 */
@Entity
@Table(name="attendanceDetailStudent")
public class AttendanceDetailStudent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Basic
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, name = "id")
	private int attendanceDetailId;

	@Basic
	@Column(nullable=false, name = "leave")
	private boolean leave;

	@Basic
	@Column(nullable=false, name = "present")
	private boolean present;

	@Basic
	@Column(nullable=false, name = "time")
	private Calendar time;

	@ManyToOne
	@JoinColumn(name="attendance", nullable=false, insertable=false, updatable=false)
	private Attendance attendance;

	@ManyToOne
	@JoinColumn(name="student", nullable=false)
	private Student student;

	public int getAttendanceDetailId() {
		return attendanceDetailId;
	}

	public void setAttendanceDetailId(int attendanceDetailId) {
		this.attendanceDetailId = attendanceDetailId;
	}

	public boolean isLeave() {
		return leave;
	}

	public void setLeave(boolean leave) {
		this.leave = leave;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public Calendar getTime() {
		return time;
	}

	public void setTime(Calendar time) {
		this.time = time;
	}

	public Attendance getAttendance() {
		return attendance;
	}

	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}