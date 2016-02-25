package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.ExamResultDetailMark;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface ExamResultDetailMarksRepository extends JpaRepository<ExamResultDetailMark, Integer>{

}
