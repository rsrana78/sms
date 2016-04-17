package com.ayp.sms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.SchoolClasses;
import com.ayp.sms.domain.Sections;
import com.ayp.sms.domain.StudentClassGroup;
import com.ayp.sms.dto.ClassGroupsDTO;
import com.ayp.sms.dto.ClassesDTO;
import com.ayp.sms.dto.SectionsDTO;
import com.ayp.sms.repository.SchoolClassRepository;
import com.ayp.sms.repository.SectionsRepository;
import com.ayp.sms.repository.StudentClassGroupRepository;
import com.ayp.sms.util.DomainMapper;

/**
 * 
 * @author rana
 *
 */

@Service("ClassSectionsService")
@Transactional(rollbackFor = Exception.class)
public class ClassSectionsServiceImpl implements ClassSectionsService{
	
	@Autowired
	private SchoolClassRepository classesRepository;
	
	@Autowired
	private SectionsRepository sectionsRepository;
	
	@Autowired
	private StudentClassGroupRepository classGroupRepository;

	@Override
	public List<ClassesDTO> getAllClasses(Integer schoolId) {
		List<ClassesDTO> classDTOList = new ArrayList<ClassesDTO>();
		List<SchoolClasses> classesList = classesRepository.getAllClassesOfSchool(schoolId);
		for(SchoolClasses clas:classesList){
			ClassesDTO dto = DomainMapper.createClassDTO(clas);
			classDTOList.add(dto);
		}
		return classDTOList;
	}

	@Override
	public List<SectionsDTO> getAllSections(Integer classId) {
		List<SectionsDTO> sectionsDTOList = new ArrayList<SectionsDTO>();
		List<Sections> sectionsList = sectionsRepository.getAllSectionsOfClass(classId);
		for(Sections section:sectionsList){
			SectionsDTO dto = DomainMapper.createSectionsDTO(section);
			sectionsDTOList.add(dto);
		}
		return sectionsDTOList;
	}

	@Override
	public List<ClassGroupsDTO> getAllGroups(Integer classId) {
		List<ClassGroupsDTO> groupDTOList = new ArrayList<ClassGroupsDTO>();
		List<StudentClassGroup> classGroupList = classGroupRepository.getAllGroupsOfClass(classId);
		for(StudentClassGroup group:classGroupList){
			ClassGroupsDTO dto = DomainMapper.createClassGroupDTO(group);
			groupDTOList.add(dto);
		}
		return groupDTOList;
	}

}
