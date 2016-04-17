package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.MainSubjects;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface MainSubjectsRepository extends JpaRepository<MainSubjects, Integer>{

}
