package com.ayp.sms.service;
/**
 * 
 * @author rana
 *
 */

public interface EmailService {
	
	public boolean sendEmail(String to, String cc, String bcc, String replyEmail, String subject, String body);
	
}
