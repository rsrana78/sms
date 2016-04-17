package com.ayp.sms.service;

import java.util.List;

import com.ayp.sms.dto.ClassGroupsDTO;
import com.ayp.sms.dto.ClassesDTO;
import com.ayp.sms.dto.SectionsDTO;

/**
 * 
 * @author rana
 *
 */

public interface ClassSectionsService {
	
	public List<ClassesDTO> getAllClasses(Integer schoolId);
	public List<SectionsDTO> getAllSections(Integer classId);
	public List<ClassGroupsDTO> getAllGroups(Integer classId);

}
