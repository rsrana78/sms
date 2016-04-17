package com.ayp.sms.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
		employee.setGender(GenderEnum.getGenderId(dto.getGender()));
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
		user.setUserName(dto.getCnic());
		return user;
	}
	
	public static ClassesDTO createClassDTO(SchoolClasses clas){
		ClassesDTO dto = new ClassesDTO();
		dto.setId(clas.getId());
		dto.setName(clas.getClasses().getName());
		if(clas.getStudentClassGroups().size()>0){
			dto.setHasGroups(true);
		}else{
			dto.setHasGroups(false);
		}
		return dto;
	}
	
	public static ClassGroupsDTO createClassGroupDTO(StudentClassGroup group){
		ClassGroupsDTO dto = new ClassGroupsDTO();
		dto.setId(group.getId());
		dto.setName(group.getGroupName());
		List<ClassGroupsDetailDTO> subjectDTOList = new ArrayList<ClassGroupsDetailDTO>();
		for(StudentClassGroupDetail subject:group.getStudentClassGroupDetails()){
			ClassGroupsDetailDTO subjectDTO = new ClassGroupsDetailDTO();
			subjectDTO.setId(subject.getId());
			subjectDTO.setSubjectName(subject.getSubject().getName().getName());
			subjectDTOList.add(subjectDTO);
		}
		dto.setSubjectList(subjectDTOList);
		return dto;
	}
	
	public static SectionsDTO createSectionsDTO(Sections section){
		SectionsDTO dto = new SectionsDTO();
		dto.setId(section.getId());
		dto.setName(section.getName());
		dto.setClassIncharge(section.getEmployee().getEmployeeName());
		return dto;
	}
	
	public static Student createStudent(StudentRegistrationDTO dto){
		Student student = new Student();
		student.setAddress(dto.getAddress());
		if(dto.getAdmissionDate() != null && !dto.getAdmissionDate().trim().isEmpty()){
			student.setAdmissionDate(DateUtil.convertStringToCalendar(dto.getAdmissionDate()));
		}else{
			student.setAdmissionDate(Calendar.getInstance());
		}
		student.setFatherCNIC(dto.getFatherCNIC());
		student.setFatherName(dto.getFatherName());
		student.setFatherContactNumber(dto.getContactNumber());
		if(dto.getImagePath() == null || dto.getImagePath().trim().isEmpty()){
			student.setPhotoPath(CompleteURLUtil.getNoImageURL());
		}else{
			student.setPhotoPath(dto.getImagePath());
		}
		student.setStudentCNIC(dto.getStudentCNIC());
		student.setStudentName(dto.getName());
		student.setGender(GenderEnum.getGenderId(dto.getGender()));
		return student;
	}
	
	public static UserInfo createUserInfo(StudentRegistrationDTO dto, String userName){
		UserInfo user = new UserInfo();
		user.setActive(true);
		user.setFullName(dto.getName());
		user.setUserName(userName);
		return user;
	}
	
	public static StudentListingDTO createStudentListingDTO(Student student){
		StudentListingDTO dto = new StudentListingDTO();
		dto.setClassName(student.getSection().getSchoolClass().getName());
		dto.setSectionName(student.getSection().getName());
		dto.setFatherName(student.getFatherName());
		dto.setImagePath(CompleteURLUtil.completeURL(student.getPhotoPath()));
		dto.setName(student.getStudentName());
		dto.setRegistrationNumber(student.getRegistrationNumber());
		return dto;
	}
	
	public static StudentDetailDTO createStudentDetailDTO(Student student){
		StudentDetailDTO dto = new StudentDetailDTO();
		dto.setClassName(student.getSection().getSchoolClass().getName());
		dto.setSectionName(student.getSection().getName());
		dto.setFatherName(student.getFatherName());
		dto.setImagePath(CompleteURLUtil.completeURL(student.getPhotoPath()));
		dto.setName(student.getStudentName());
		dto.setRegistrationNumber(student.getRegistrationNumber());
		dto.setAddress(student.getAddress());
		dto.setAdmissionDate(DateUtil.convertCalendarToString(student.getAdmissionDate()));
		dto.setCnic(student.getStudentCNIC());
		dto.setContactNumber(student.getFatherContactNumber());
		dto.setFatherCnic(student.getFatherCNIC());
		dto.setGender(GenderEnum.getGenderName(student.getGender()));
		dto.setGroupName(student.getClassGroup().getGroupName());
		return dto;
	}
	
}
