package com.ayp.sms.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author rana
 *
 */

@Service
@Repository
@Transactional(rollbackFor = Exception.class)
public class TextMessageServiceImpl implements TextMessageService{

	@Override
	public void sendMessage(String from, String to, String message) {
		// TODO Auto-generated method stub
		
	}

}
