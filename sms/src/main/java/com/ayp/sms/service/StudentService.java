package com.ayp.sms.service;

import java.util.List;

import com.ayp.sms.dto.NewRecordCreatedDTO;
import com.ayp.sms.dto.StudentDetailDTO;
import com.ayp.sms.dto.StudentFilterDTO;
import com.ayp.sms.dto.StudentListingDTO;
import com.ayp.sms.dto.StudentRegistrationDTO;

/**
 * 
 * @author rana
 *
 */

public interface StudentService {
	
	public NewRecordCreatedDTO createNewStudent(StudentRegistrationDTO dto);
	List<StudentListingDTO> getActiveStudentsOfClass(StudentFilterDTO filter);
	List<StudentListingDTO> getInactiveStudentsOfSchool(StudentFilterDTO filter);
	List<StudentListingDTO> getPassedoutStudentsOfSchool(StudentFilterDTO filter);
	StudentDetailDTO getStudentDetail(String regNumber);

}
