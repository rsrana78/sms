package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.Salary;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface SalaryRepository extends JpaRepository<Salary, Integer>{

}
