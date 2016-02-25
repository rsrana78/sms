package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.TestResult;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface TestResultRepository extends JpaRepository<TestResult, Integer>{

}
