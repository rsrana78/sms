package com.ayp.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.dto.ContactUsDTO;

/**
 * 
 * @author rana
 *
 */
@Service
@Repository
@Transactional(rollbackFor = Exception.class)
public class ContactUsServiceImpl implements ContactUsService{
	
	@Autowired
	private EmailService emailService;

	@Override
	public boolean createContactUsRequest(ContactUsDTO dto) {
		StringBuilder body = new StringBuilder();
		body.append("\nName:"+dto.getName());
		body.append("\nPhone:"+dto.getPhone());
		body.append("\nMessage:"+dto.getMessage());
		if(emailService.sendEmail("rsrana78@yahoo.com", null, null, dto.getEmail(), "New Contact Request", body.toString()))
			return true;
		else
			return false;
	}

}
