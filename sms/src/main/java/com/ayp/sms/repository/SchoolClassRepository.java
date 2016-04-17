package com.ayp.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.SchoolClasses;

/**
 * 
 * 
 * @author rana
 *
 *
 */

@Transactional
public interface SchoolClassRepository extends JpaRepository<SchoolClasses, Integer>{
	
	@Query("select classes from SchoolClasses classes where classes.campus.id = ?1")
	List<SchoolClasses> getAllClassesOfSchool(Integer idSchool);

}
