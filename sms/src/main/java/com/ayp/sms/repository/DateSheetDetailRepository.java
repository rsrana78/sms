package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.DateSheetDetail;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface DateSheetDetailRepository extends JpaRepository<DateSheetDetail, Integer>{

}
