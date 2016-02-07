package com.ayp.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.Campus;
import com.ayp.sms.repository.CampusRepository;

/**
 * 
 * @author rana
 *
 */

@Repository
@Service("CampusService")
@Transactional(rollbackFor = Exception.class)
public class CampusServiceImpl implements CampusService{

	@Autowired
	private CampusRepository campusRepository;

	@Override
	public List<Campus> getAllCampus() {
		return campusRepository.findAll();
	}

}
