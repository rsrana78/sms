package com.ayp.sms.domain;
/**
 * 
 * @author rana
 * 
 */

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the studentClassGroup database table.
 * 
 */
@Entity
@Table(name="studentClassGroup")
public class StudentClassGroup implements Serializable {
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
	@Column(nullable=false, length=45, name = "groupName")
	private String groupName;

	@ManyToOne
	@JoinColumn(name="class", nullable=false)
	private SchoolClass schoolClass;

	@Basic
	@OneToMany(mappedBy="id")
	private List<StudentClassGroupDetail> studentClassGroupDetails;

	@Basic
	@OneToMany(mappedBy="registrationNumber")
	private List<Student> students;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public SchoolClass getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}

	public List<StudentClassGroupDetail> getStudentClassGroupDetails() {
		return studentClassGroupDetails;
	}

	public void setStudentClassGroupDetails(
			List<StudentClassGroupDetail> studentClassGroupDetails) {
		this.studentClassGroupDetails = studentClassGroupDetails;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}