package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.Student;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
