package com.ayp.sms.service;

import java.util.List;

import com.ayp.sms.domain.EmployeeType;
import com.ayp.sms.domain.Qualification;
import com.ayp.sms.dto.EmployeeDTO;
import com.ayp.sms.dto.EmployeeDetailDTO;
import com.ayp.sms.dto.EmployeeListingDTO;
import com.ayp.sms.dto.ReasonDTO;

public interface EmployeeService {
	
	public List<EmployeeType> getEmployeeTypeList();
	public List<Qualification> getQualificationList();
	public List<EmployeeListingDTO> getAllEmployees(Integer campusId);
	public List<EmployeeListingDTO> getAllTerminatedEmployees(Integer campusId);
	public String createNewEmployee(EmployeeDTO dto);
	public boolean terminateEmployee(ReasonDTO dto);
	public EmployeeDetailDTO getEmployeeDetail(Integer id);
	public EmployeeDTO editAnEmployee(Integer id);
	public String updateEmployee(EmployeeDTO dto);
}
