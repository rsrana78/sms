package com.ayp.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.repository.EmployeeRepository;

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

}
