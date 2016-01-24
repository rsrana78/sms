package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.Employee;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
