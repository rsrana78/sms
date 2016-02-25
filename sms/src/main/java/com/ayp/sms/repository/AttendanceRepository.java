package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.Attendance;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface AttendanceRepository extends JpaRepository<Attendance, Integer>{

}
