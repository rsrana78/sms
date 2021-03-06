package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.AttendanceDetailEmployee;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface AttendanceDetailEmployeeRepository extends JpaRepository<AttendanceDetailEmployee, Integer>{

}
