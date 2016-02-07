package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.StudentClassGroupDetail;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface StudentClassGroupDetailRepository extends JpaRepository<StudentClassGroupDetail, Integer>{

}
