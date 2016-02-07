package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.Exam;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface ExamRepository extends JpaRepository<Exam, Integer>{

}
