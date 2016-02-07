package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.Fine;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface FineRepository extends JpaRepository<Fine, Integer>{

}
