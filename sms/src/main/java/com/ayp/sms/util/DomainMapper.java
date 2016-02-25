package com.ayp.sms.util;

import com.ayp.sms.domain.Campus;
import com.ayp.sms.dto.SchoolDTO;

/**
 * 
 * @author rana
 *
 */

public class DomainMapper {
	
	public static SchoolDTO createSchoolDTO(Campus campus){
		SchoolDTO dto = new SchoolDTO();
		dto.setAddress(campus.getAddress());
		dto.setMonogramPath(campus.getSchool().getMonogram());
		dto.setOwnerName(campus.getSchool().getOwnerName());
		dto.setOwnerImagePath(campus.getSchool().getOwnerImage());
		dto.setPrincipalName(campus.getPrincipal().getEmployeeName());
		dto.setPrincipalImagePath(campus.getPrincipal().getImagePath());
		dto.setSchoolName(campus.getCampusName());
		return dto;
	}

}
