package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.Fee;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface FeeRepository extends JpaRepository<Fee, Integer>{

}
