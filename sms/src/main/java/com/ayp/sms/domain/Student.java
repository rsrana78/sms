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
 * The persistent class for the students database table.
 * 
 */
@Entity
@Table(name="students")
public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Basic
	@Column(unique=true, nullable=false, name = "registrationNumber")
	private String registrationNumber;

	@Basic
	@Column(nullable=false, name = "address")
	private String address;

	@Basic
	@Column(name = "admissionCancel")
	private boolean admissionCancel;

	@Basic
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Calendar admissionDate;

	@Basic
	@Column(nullable=false, name = "fatherContactNumber")
	private String fatherContactNumber;

	@Basic
	@Column(nullable=false, name = "fatherName")
	private String fatherName;

	
	@Basic
	@Column(name = "hasLeft")
	private boolean hasLeft;

	@Basic
	@Column(nullable=false, name = "name")
	private String studentName;

	@Basic
	@Column(name = "passedOut")
	private boolean passedOut;

	@Basic
	@Column(nullable=false, name = "photoPath")
	private String photoPath;

	@Basic
	@Column(name = "reason")
	private String reason;

	@Basic
	@OneToMany(mappedBy="attendanceDetailId")
	private List<AttendanceDetailStudent> attendanceDetail;

	@Basic
	@OneToMany(mappedBy="id")
	private List<ClassDetail> classDetails;

	@ManyToOne
	@JoinColumn(name="school", nullable=false)
	private Campus campus;

	@ManyToOne
	@JoinColumn(name="admissionBy", nullable=false)
	private Employee employee;

	@ManyToOne
	@JoinColumn(name="class", nullable=false)
	private Sections section;

	@Basic
	@OneToMany(mappedBy="id")
	private List<ExamResultDetailMark> examResulMarks;

	@Basic
	@OneToMany(mappedBy="id")
	private List<Fine> fines;

	@Basic
	@OneToMany(mappedBy="id")
	private List<MonthlyFeeDetail> monthlyFeeDetails;

	@ManyToOne
	@JoinColumn(name="studentClassGroup")
	private StudentClassGroup classGroup;

	@Basic
	@OneToMany(mappedBy="id")
	private List<TestResult> testResults;

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isAdmissionCancel() {
		return admissionCancel;
	}

	public void setAdmissionCancel(boolean admissionCancel) {
		this.admissionCancel = admissionCancel;
	}

	public Calendar getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Calendar admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getFatherContactNumber() {
		return fatherContactNumber;
	}

	public void setFatherContactNumber(String fatherContactNumber) {
		this.fatherContactNumber = fatherContactNumber;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public boolean isHasLeft() {
		return hasLeft;
	}

	public void setHasLeft(boolean hasLeft) {
		this.hasLeft = hasLeft;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public boolean isPassedOut() {
		return passedOut;
	}

	public void setPassedOut(boolean passedOut) {
		this.passedOut = passedOut;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public List<AttendanceDetailStudent> getAttendanceDetail() {
		return attendanceDetail;
	}

	public void setAttendanceDetail(List<AttendanceDetailStudent> attendanceDetail) {
		this.attendanceDetail = attendanceDetail;
	}

	public List<ClassDetail> getClassDetails() {
		return classDetails;
	}

	public void setClassDetails(List<ClassDetail> classDetails) {
		this.classDetails = classDetails;
	}

	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Sections getSection() {
		return section;
	}

	public void setSection(Sections section) {
		this.section = section;
	}

	public List<ExamResultDetailMark> getExamResulMarks() {
		return examResulMarks;
	}

	public void setExamResulMarks(List<ExamResultDetailMark> examResulMarks) {
		this.examResulMarks = examResulMarks;
	}

	public List<Fine> getFines() {
		return fines;
	}

	public void setFines(List<Fine> fines) {
		this.fines = fines;
	}

	public List<MonthlyFeeDetail> getMonthlyFeeDetails() {
		return monthlyFeeDetails;
	}

	public void setMonthlyFeeDetails(List<MonthlyFeeDetail> monthlyFeeDetails) {
		this.monthlyFeeDetails = monthlyFeeDetails;
	}

	public StudentClassGroup getClassGroup() {
		return classGroup;
	}

	public void setClassGroup(StudentClassGroup classGroup) {
		this.classGroup = classGroup;
	}

	public List<TestResult> getTestResults() {
		return testResults;
	}

	public void setTestResults(List<TestResult> testResults) {
		this.testResults = testResults;
	}

}