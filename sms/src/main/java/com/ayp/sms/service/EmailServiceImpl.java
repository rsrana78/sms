package com.ayp.sms.service;

import javax.mail.MessagingException;

import org.springframework.stereotype.Service;

import com.ayp.sms.email.Email;

/**
 * 
 * @author rana
 *
 */

@Service
public class EmailServiceImpl implements EmailService{

	@Override
	public boolean sendEmail(String to, String cc, String bcc, String replyEmail, String subject, String body) {
		try {
			Email email = new Email();
			try {
				if(email.sendNormalEmail(to, cc, bcc, replyEmail, subject, body))
					return true;
				else
					return false;
			} catch (MessagingException e) {
				e.printStackTrace();
				return false;
			}
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
		
}
