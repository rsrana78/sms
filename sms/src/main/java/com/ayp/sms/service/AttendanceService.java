package com.ayp.sms.service;
/**
 * 
 * @author rana
 *
 */

public interface AttendanceService {
	public String markAttendanceOfStudent(String registrationNumber);
	public String markAttendanceOfEmployee(Integer id);
}
