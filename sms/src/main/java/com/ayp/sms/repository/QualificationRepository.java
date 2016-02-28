package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.Qualification;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface QualificationRepository extends JpaRepository<Qualification, Integer>{

}
