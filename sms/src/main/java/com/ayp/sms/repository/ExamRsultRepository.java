package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.ExamResult;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface ExamRsultRepository extends JpaRepository<ExamResult, Integer>{

}
