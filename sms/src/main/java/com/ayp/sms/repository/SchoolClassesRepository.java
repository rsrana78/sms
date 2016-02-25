package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.SchoolClasses;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface SchoolClassesRepository extends JpaRepository<SchoolClasses, Integer>{

}
