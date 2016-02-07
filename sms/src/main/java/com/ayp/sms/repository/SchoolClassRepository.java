package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.SchoolClass;

/**
 * 
 * 
 * @author rana
 *
 *
 */

@Transactional
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Integer>{

}
