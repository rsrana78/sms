package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.EmployeeType;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface EmployeeTypeRepository extends JpaRepository<EmployeeType, Integer>{

}
