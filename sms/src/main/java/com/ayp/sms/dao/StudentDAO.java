package com.ayp.sms.dao;

import java.util.List;

import com.ayp.sms.domain.Student;
import com.ayp.sms.dto.StudentFilterDTO;

/**
 * 
 * @author rana
 *
 */

public interface StudentDAO {
	String getRegistrationNumber(Integer schoolId);
	Integer getRollNumber(Integer sectionId);
	List<Student> getFilteredStudents(StudentFilterDTO filter);
}
