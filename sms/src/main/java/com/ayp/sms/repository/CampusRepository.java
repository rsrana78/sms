package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.Campus;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface CampusRepository extends JpaRepository<Campus, Integer>{

}
