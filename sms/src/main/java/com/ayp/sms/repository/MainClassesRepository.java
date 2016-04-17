package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.MainClasses;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface MainClassesRepository extends JpaRepository<MainClasses, Integer>{

}
