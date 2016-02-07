package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.MonthlyFeeDetail;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface MonthlyFeeDetailRepository extends JpaRepository<MonthlyFeeDetail, Integer>{

}
