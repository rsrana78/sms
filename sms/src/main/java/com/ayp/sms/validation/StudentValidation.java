package com.ayp.sms.validation;

import com.ayp.sms.dto.StudentRegistrationDTO;
import com.ayp.sms.dto.ValidationStatusDTO;

/**
 * 
 * @author rana
 *
 */

public class StudentValidation {
	
	
	public static ValidationStatusDTO validateStudent(StudentRegistrationDTO student){
		ValidationStatusDTO dto = new ValidationStatusDTO();
		dto.setValidated(true);
		if(student.getName() == null || student.getName().trim().isEmpty()){
			dto.setValidated(false);
			dto.setValidationMessage("Please enter student name");
			return dto;
		}
		if(student.getFatherName() == null || student.getFatherName().trim().isEmpty()){
			dto.setValidated(false);
			dto.setValidationMessage("Please enter father name");
			return dto;
		}
		if(student.getFatherCNIC() == null || student.getFatherCNIC().trim().isEmpty()){
			dto.setValidated(false);
			dto.setValidationMessage("Please enter father CNIC number");
			return dto;
		}
		if(student.getFatherCNIC() != null && student.getFatherCNIC().trim().length()<13){
			dto.setValidated(false);
			dto.setValidationMessage("Please enter valid father CNIC number");
			return dto;
		}
		if(student.getAddress() == null || student.getAddress().trim().isEmpty()){
			dto.setValidated(false);
			dto.setValidationMessage("Please enter address");
			return dto;
		}
		if(student.getContactNumber() == null || student.getContactNumber().trim().isEmpty()){
			dto.setValidated(false);
			dto.setValidationMessage("Please enter contact number");
			return dto;
		}
		if(student.getContactNumber() != null && student.getContactNumber().trim().length()<11){
			dto.setValidated(false);
			dto.setValidationMessage("Please enter valid contact number");
			return dto;
		}
		if(student.getClassId() == null){
			dto.setValidated(false);
			dto.setValidationMessage("Please select class for admission");
			return dto;
		}
		if(student.getGender() == null || student.getGender().trim().isEmpty()){
			dto.setValidated(false);
			dto.setValidationMessage("Please select gender of student");
			return dto;
		}
		return dto;
	}

}
