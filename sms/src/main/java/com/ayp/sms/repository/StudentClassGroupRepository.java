package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.StudentClassGroup;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface StudentClassGroupRepository extends JpaRepository<StudentClassGroup, Integer>{

}
