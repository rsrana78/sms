package com.ayp.sms.domain;
/**
 * 
 * @author rana
 * 
 */

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the studentClassGroupDetail database table.
 * 
 */
@Entity
@Table(name="studentClassGroupDetail")
public class StudentClassGroupDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Basic
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, name="id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name="group", nullable=false)
	private StudentClassGroup studentClassGroup;

	@ManyToOne
	@JoinColumn(name="subject", nullable=false)
	private ClassesSubjects subject;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StudentClassGroup getStudentClassGroup() {
		return studentClassGroup;
	}

	public void setStudentClassGroup(StudentClassGroup studentClassGroup) {
		this.studentClassGroup = studentClassGroup;
	}

	public ClassesSubjects getSubject() {
		return subject;
	}

	public void setSubject(ClassesSubjects subject) {
		this.subject = subject;
	}
	
}