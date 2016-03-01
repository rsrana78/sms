package com.ayp.sms.service;

import java.util.ArrayList;
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
import com.ayp.sms.repository.CampusRepository;
import com.ayp.sms.repository.EmployeeRepository;
import com.ayp.sms.repository.EmployeeTypeRepository;
import com.ayp.sms.repository.QualificationRepository;
import com.ayp.sms.repository.UserInfoRepository;
import com.ayp.sms.util.DomainMapper;

import static com.ayp.sms.util.ApplicationMessages.EMPLOYEE_CREATED;

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
		List<Employee> employeeList = employeeRepository.getAllEmployee(campusId);
		for(Employee employee:employeeList){
			employeeDTOList.add(DomainMapper.createEmployeeDTO(employee));
		}
		return employeeDTOList;
	}

	@Override
	public String createNewEmployee(EmployeeDTO dto) {
		Campus campus = campusRepository.findOne(securityService.getCampusId());
		EmployeeType employeeType = employeeTypeRepository.findOne(dto.getType());
		Qualification qualification = qualificationRepository.findOne(dto.getQualification());
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

}
