package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.Subject;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface SubjectRepository extends JpaRepository<Subject, Integer>{

}
