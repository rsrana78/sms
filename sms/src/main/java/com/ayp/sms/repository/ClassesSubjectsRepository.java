package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.ClassesSubjects;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface ClassesSubjectsRepository extends JpaRepository<ClassesSubjects, Integer>{

}
