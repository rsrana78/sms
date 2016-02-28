package com.ayp.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.EmployeeType;
import com.ayp.sms.domain.Qualification;
import com.ayp.sms.repository.EmployeeRepository;
import com.ayp.sms.repository.EmployeeTypeRepository;
import com.ayp.sms.repository.QualificationRepository;

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

	@Override
	public List<EmployeeType> getEmployeeTypeList() {
		return employeeTypeRepository.findAll();
	}

	@Override
	public List<Qualification> getQualificationList() {
		return qualificationRepository.findAll();
	}

}
