package com.ayp.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.StudentClassGroup;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface StudentClassGroupRepository extends JpaRepository<StudentClassGroup, Integer>{
	
	@Query("select group from StudentClassGroup group where group.schoolClass.id = ?1")
	List<StudentClassGroup> getAllGroupsOfClass(Integer classId);

}
