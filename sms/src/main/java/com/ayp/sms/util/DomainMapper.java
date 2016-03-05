package com.ayp.sms.util;

import java.math.BigDecimal;
import java.util.Calendar;

import com.ayp.sms.domain.*;
import com.ayp.sms.dto.*;
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
	
	public static EmployeeDTO createEmployeeDTO(Employee employee){
		EmployeeDTO dto = new EmployeeDTO();
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
		employee.setSalary(new BigDecimal(dto.getSalary()));
		employee.setServing(true);
		if(dto.getJoiningDate() != null)
			employee.setJoiningDate(DateUtil.convertStringToCalendar(dto.getJoiningDate()));
		else
			employee.setJoiningDate(Calendar.getInstance());
		employee.setEntryDate(Calendar.getInstance());
		return employee;
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
