package com.ayp.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.Student;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface StudentRepository extends JpaRepository<Student, String>{
	
	@Query("select count(student.registrationNumber) from Student student where student.studentName=?1 "
			+"and student.fatherName=?2 and student.fatherCNIC=?3")
	Integer checkStudentExist(String name, String fatherName, String fatherCNIC);
	
	@Query("select student from Student student where student.section.id=?1 and student.admissionCancel=0 "
			+ "and student.hasLeft=0 and student.passedOut=0")
	List<Student> getActiveStudentsOfClass(Integer classId);
	
	@Query("select student from Student student where student.campus.id=?1 and student.admissionCancel=0 "
			+ "and student.hasLeft=0 and student.passedOut=0")
	List<Student> getActiveStudentsOfSchool(Integer schoolId);
	
	@Query("select student from Student student where student.campus.id=?1 and (student.admissionCancel=1 "
			+ "and student.hasLeft=1) and student.passedOut=0")
	List<Student> getInActiveStudentsOfSchool(Integer schoolId);
	
	@Query("select student from Student student where student.campus.id=?1 and student.passedOut=1")
	List<Student> getPassedOutStudentsOfSchool(Integer schoolId);
	
	@Query("select student from Student student where student.registrationNumber = ?1 and student.campus.id=?2")
	Student getStudentForDetail(String regNumber, Integer schoolId);

}
