package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.DateSheet;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface DateSheetRepository extends JpaRepository<DateSheet, Integer>{

}
