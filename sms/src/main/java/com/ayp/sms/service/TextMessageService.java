package com.ayp.sms.service;
/**
 * 
 * @author rana
 *
 */

public interface TextMessageService {
	public void sendMessage(String from, String to, String message);
}
