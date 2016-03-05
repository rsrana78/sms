package com.ayp.sms.validation;

import com.ayp.sms.dto.EmployeeDTO;
import com.ayp.sms.dto.ValidationStatusDTO;

/**
 * 
 * @author rana
 *
 */

public class EmployeeValidation {
	
	public static ValidationStatusDTO validateNewEmployee(EmployeeDTO employee){
		ValidationStatusDTO dto = new ValidationStatusDTO();
		dto.setValidated(true);
		if(employee.getAddress() == null || employee.getAddress().trim().isEmpty()){
			dto.setValidated(false);
			dto.setValidationMessage("Please provide a valid address");
		}else if(employee.getCnic() == null || employee.getCnic().trim().isEmpty()){
			dto.setValidated(false);
			dto.setValidationMessage("Please provide CNIC");
		}else if(employee.getCnic() != null && employee.getCnic().length()<13){
			dto.setValidated(false);
			dto.setValidationMessage("Please provide a valid CNIC");
		}else if(employee.getEmail() == null || employee.getEmail().trim().isEmpty()){
			dto.setValidated(false);
			dto.setValidationMessage("Please provide a valid email address");
		}else if(employee.getFatherName() == null || employee.getFatherName().trim().isEmpty()){
			dto.setValidated(false);
			dto.setValidationMessage("Please provide valid father name");
		}else if(employee.getName() == null || employee.getName().trim().isEmpty()){
			dto.setValidated(false);
			dto.setValidationMessage("Please provide a valid name");
		}else if(employee.getPhone() == null || employee.getPhone().trim().isEmpty()){
			dto.setValidated(false);
			dto.setValidationMessage("Please provide a valid phone number");
		}else if(employee.getQualification() == null){
			dto.setValidated(false);
			dto.setValidationMessage("Please select qualification for this employee");
		}else if(employee.getSalary() == null || employee.getSalary().trim().isEmpty()){
			dto.setValidated(false);
			dto.setValidationMessage("Please specify salary for this employee");
		}else if(employee.getEmpType() == null){
			dto.setValidated(false);
			dto.setValidationMessage("Please select an employee type");
		}else if(employee.getGender() == null){
			dto.setValidated(false);
			dto.setValidationMessage("Please specify gender for this employee");
		}
		return dto;
	}
	
}
