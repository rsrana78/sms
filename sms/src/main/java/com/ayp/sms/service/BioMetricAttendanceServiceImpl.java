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
public class BioMetricAttendanceServiceImpl implements BioMetricAttendanceService{

	@Override
	public String markAttendance(String registrationNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
