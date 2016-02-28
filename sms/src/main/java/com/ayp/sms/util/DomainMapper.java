package com.ayp.sms.util;

import com.ayp.sms.domain.Campus;
import com.ayp.sms.domain.Employee;
import com.ayp.sms.dto.EmployeeDTO;
import com.ayp.sms.dto.SchoolDTO;

/**
 * 
 * @author rana
 *
 */

public class DomainMapper {
	
	public static SchoolDTO createSchoolDTO(Campus campus){
		SchoolDTO dto = new SchoolDTO();
		dto.setMonogramPath(CompleteURLUtil.completeURL(campus.getMonogram()));
		dto.setSchoolName(campus.getCampusName());
		return dto;
	}
	
	public static EmployeeDTO createEmployeeDTO(Employee employee){
		EmployeeDTO dto = new EmployeeDTO();
		dto.setId(employee.getEmployeeId());
		dto.setAddress(employee.getEmployeeAddress());
		dto.setCnic(employee.getCnic());
		dto.setEmpQualification(employee.getQualification().getName());
		dto.setEmpType(employee.getEmployeeType().getEmployeeTypeName());
		dto.setFatherName(employee.getFatherName());
		if(employee.getUser() != null)
			dto.setEmail(employee.getUser().getEmail());
		dto.setImagePath(employee.getImagePath());
		dto.setName(employee.getEmployeeName());
		dto.setPhone(employee.getContactNumber());
		dto.setSalary(employee.getSalary().toString());
		return dto;
	}
	
}
