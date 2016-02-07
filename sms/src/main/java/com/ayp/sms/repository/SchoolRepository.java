package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.School;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface SchoolRepository extends JpaRepository<School, Integer>{

}
