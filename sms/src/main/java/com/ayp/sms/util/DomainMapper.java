package com.ayp.sms.util;

import java.util.Calendar;

import com.ayp.sms.domain.Campus;
import com.ayp.sms.domain.Employee;
import com.ayp.sms.domain.UserInfo;
import com.ayp.sms.dto.EmployeeDTO;
import com.ayp.sms.dto.EmployeeDetailDTO;
import com.ayp.sms.dto.EmployeeListingDTO;
import com.ayp.sms.dto.SchoolDTO;
import com.ayp.sms.enums.GenderEnum;

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
	
	public static EmployeeDetailDTO createEmployeeDetailDTO(Employee employee){
		EmployeeDetailDTO dto = new EmployeeDetailDTO();
		dto.setId(employee.getEmployeeId());
		dto.setAddress(employee.getEmployeeAddress());
		dto.setCnic(employee.getCnic());
		dto.setQualification(employee.getQualification().getName());
		dto.setEmpType(employee.getEmployeeType().getEmployeeTypeName());
		dto.setFatherName(employee.getFatherName());
		if(employee.getUser() != null)
			dto.setEmail(employee.getUser().getEmail());
		dto.setImagePath(employee.getImagePath());
		dto.setName(employee.getEmployeeName());
		dto.setPhone(employee.getContactNumber());
		dto.setSalary(employee.getSalary().toString());
		dto.setJoiningDate(DateUtil.convertCalendarToString(employee.getJoiningDate()));
		return dto;
	}
	
	public static Employee createEmployee(EmployeeDTO dto){
		Employee employee = new Employee();
		employee.setCnic(dto.getCnic());
		employee.setContactNumber(dto.getPhone());
		employee.setEmployeeAddress(dto.getAddress());
		employee.setEmployeeName(dto.getName());
		employee.setFatherName(dto.getFatherName());
		if(dto.getGender().equals(GenderEnum.MALE.getGender()))
			employee.setGender(GenderEnum.MALE.getId());
		else if(dto.getGender().equals(GenderEnum.FEMALE.getGender()))
			employee.setGender(GenderEnum.FEMALE.getId());
		if(dto.getImagePath() != null)
			employee.setImagePath(dto.getImagePath());
		else
			employee.setImagePath(CompleteURLUtil.getNoImageURL());
		employee.setSalary(dto.getSalary());
		employee.setServing(true);
		if(dto.getJoiningDate() != null)
			employee.setJoiningDate(DateUtil.convertStringToCalendar(dto.getJoiningDate()));
		else
			employee.setJoiningDate(Calendar.getInstance());
		employee.setEntryDate(Calendar.getInstance());
		return employee;
	}
	
	public static EmployeeDTO createEmployeeDTO(Employee employee){
		EmployeeDTO dto = new EmployeeDTO();
		dto.setId(employee.getEmployeeId());
		dto.setAddress(employee.getEmployeeAddress());
		dto.setCnic(employee.getCnic());
		dto.setQualification(employee.getQualification().getId());
		dto.setEmpType(employee.getEmployeeType().getId());
		dto.setFatherName(employee.getFatherName());
		if(employee.getUser() != null)
			dto.setEmail(employee.getUser().getEmail());
		dto.setImagePath(employee.getImagePath());
		dto.setName(employee.getEmployeeName());
		dto.setPhone(employee.getContactNumber());
		dto.setSalary(employee.getSalary());
		dto.setJoiningDate(DateUtil.convertCalendarToString(employee.getJoiningDate()));
		return dto;
	}
	
	public static EmployeeListingDTO createEmployeeListingDTO(Employee employee){
		EmployeeListingDTO dto = new EmployeeListingDTO();
		dto.setId(employee.getEmployeeId());
		dto.setName(employee.getEmployeeName());
		dto.setType(employee.getEmployeeType().getEmployeeTypeName());
		dto.setReason(employee.getReason());
		dto.setImagePath(CompleteURLUtil.completeURL(employee.getImagePath()));
		dto.setDate(DateUtil.convertCalendarToString(employee.getEntryDate()));
		dto.setCnic(employee.getCnic());
		dto.setPhone(employee.getContactNumber());
		if(employee.getTerminationDate() != null)
			dto.setTerminationDate(DateUtil.convertCalendarToString(employee.getTerminationDate()));
		return dto;
	}
	
	public static UserInfo createUserInfo(EmployeeDTO dto){
		UserInfo user = new UserInfo();
		user.setActive(true);
		user.setEmail(dto.getEmail());
		user.setFullName(dto.getName());
		user.setSuperUser(false);
		user.setUserName(dto.getCnic());
		return user;
	}
	
}
