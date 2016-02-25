package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.AttendanceDetailStudent;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface AttendanceDetailStudentRepository extends JpaRepository<AttendanceDetailStudent, Integer>{

}
