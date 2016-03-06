package com.ayp.sms.service;

import static com.ayp.sms.util.ApplicationMessages.EMPLOYEE_CREATED;
import static com.ayp.sms.util.ApplicationMessages.EMPLOYEE_EXIST;
import static com.ayp.sms.util.ApplicationMessages.PRINCIPAL_EXIST;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.Campus;
import com.ayp.sms.domain.Employee;
import com.ayp.sms.domain.EmployeeType;
import com.ayp.sms.domain.Qualification;
import com.ayp.sms.domain.UserInfo;
import com.ayp.sms.dto.EmployeeDTO;
import com.ayp.sms.dto.ReasonDTO;
import com.ayp.sms.repository.CampusRepository;
import com.ayp.sms.repository.EmployeeRepository;
import com.ayp.sms.repository.EmployeeTypeRepository;
import com.ayp.sms.repository.QualificationRepository;
import com.ayp.sms.repository.UserInfoRepository;
import com.ayp.sms.util.DomainMapper;

/**
 * 
 * @author rana
 *
 */

@Repository
@Service("EmployeeService")
@Transactional(rollbackFor = Exception.class)
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;
	
	@Autowired
	private QualificationRepository qualificationRepository;
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private CampusRepository campusRepository;

	@Override
	public List<EmployeeType> getEmployeeTypeList() {
		return employeeTypeRepository.findAll();
	}

	@Override
	public List<Qualification> getQualificationList() {
		return qualificationRepository.findAll();
	}

	@Override
	public List<EmployeeDTO> getAllEmployees(Integer campusId) {
		if(campusId == null)
			return null;
		List<EmployeeDTO> employeeDTOList = new ArrayList<EmployeeDTO>();
		List<Employee> employeeList = employeeRepository.getAllEmployees(campusId);
		for(Employee employee:employeeList){
			employeeDTOList.add(DomainMapper.createEmployeeDTO(employee));
		}
		return employeeDTOList;
	}

	@Override
	public String createNewEmployee(EmployeeDTO dto) {
		Campus campus = null;
		Employee existing = employeeRepository.getEmployeeFromCNIC(dto.getCnic());
		if(existing != null)
			return EMPLOYEE_EXIST;
		if(new Integer(dto.getEmpType()) == 1){
			campus = campusRepository.getOne(securityService.getCampusId());
			if(campus != null){
				existing = campus.getPrincipal();
				if(existing != null && !existing.isServing())
					return PRINCIPAL_EXIST;
			}
		}
		campus = campusRepository.findOne(securityService.getCampusId());
		EmployeeType employeeType = employeeTypeRepository.findOne(new Integer(dto.getEmpType()));
		Qualification qualification = qualificationRepository.findOne(new Integer(dto.getQualification()));
		Employee employee = DomainMapper.createEmployee(dto);
		employee.setCampuses(campus);
		employee.setEmployeeType(employeeType);
		employee.setQualification(qualification);
		employee = employeeRepository.saveAndFlush(employee);
		UserInfo user = DomainMapper.createUserInfo(dto);
		user.setEmployee(employee);
		user.setSchoolCampus(campus);
		Sha256Hash encryptedPassword = new Sha256Hash(dto.getCnic());
		user.setPassword(encryptedPassword.toHex());
		userInfoRepository.save(user);
		return EMPLOYEE_CREATED;
	}
	
	@Override
	public List<EmployeeDTO> getAllTerminatedEmployees(Integer campusId) {
		if(campusId == null)
			return null;
		List<EmployeeDTO> employeeDTOList = new ArrayList<EmployeeDTO>();
		List<Employee> employeeList = employeeRepository.getAllTerminatedEmployees(campusId);
		for(Employee employee:employeeList){
			employeeDTOList.add(DomainMapper.createEmployeeDTO(employee));
		}
		return employeeDTOList;
	}

	@Override
	public boolean terminateEmployee(ReasonDTO dto) {
		if(dto.getId() != null && dto.getReason() != null){
			String[] ids = dto.getId().split(",");
			if(ids.length>1)
				return false;
			Employee employee = employeeRepository.findOne(new Integer(dto.getId()));
			employee.setServing(false);
			employee.setReason(dto.getReason());
			employee.setTerminationDate(Calendar.getInstance());
			employee.getUser().setActive(false);
			employeeRepository.save(employee);
			return true;
		}
		return false;
	}
}
