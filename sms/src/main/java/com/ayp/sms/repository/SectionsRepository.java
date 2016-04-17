package com.ayp.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.Sections;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface SectionsRepository extends JpaRepository<Sections, Integer>{
	
	@Query("select section from Sections section where section.schoolClass.id = ?1")
	List<Sections> getAllSectionsOfClass(Integer classId);
	
	@Query("select section from Sections section where section.employee.employeeId=?1 and section.sessionEnd=0")
	Sections getSectionByIncharge(Integer id);

}
