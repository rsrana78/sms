package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.ClassDetail;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface ClassDetailRepository extends JpaRepository<ClassDetail, Integer>{

}
