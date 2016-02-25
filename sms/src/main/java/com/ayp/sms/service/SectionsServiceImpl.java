package com.ayp.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.repository.SectionsRepository;

/**
 * 
 * @author rana
 *
 */

@Repository
@Service("SectionsService")
@Transactional(rollbackFor = Exception.class)
public class SectionsServiceImpl implements SectionsService{
	
	@Autowired
	private SectionsRepository sectionsRepository;

}
