package com.ayp.sms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.Campus;
import com.ayp.sms.dto.SchoolDTO;
import com.ayp.sms.repository.SchoolRepository;
import com.ayp.sms.util.DomainMapper;

/**
 * 
 * @author rana
 *
 */

@Service
@Repository
@Transactional(rollbackFor = Exception.class)
public class SchoolServiceImpl implements SchoolService{
	
	@Autowired
	private SchoolRepository schoolRepository;
	
	@Autowired
	private CampusService campusService;

	@Override
	public List<SchoolDTO> getAllRegisteredSchool() {
		List<Campus> schoolList = campusService.getAllCampus();
		List<SchoolDTO> schoolDTOList = new ArrayList<SchoolDTO>();
		for(Campus campus:schoolList){
			schoolDTOList.add(DomainMapper.createSchoolDTO(campus));
		}
		return schoolDTOList;
	}

}
