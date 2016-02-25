package com.ayp.sms.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author rana
 *
 */

@Service
@Repository
@Transactional(rollbackFor = Exception.class)
public class AttendanceServiceImpl implements AttendanceService{

	@Override
	public String markAttendanceOfStudent(String registrationNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String markAttendanceOfEmployee(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
