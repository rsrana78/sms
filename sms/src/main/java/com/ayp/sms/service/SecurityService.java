package com.ayp.sms.service;

import com.ayp.sms.domain.SessionData;

public interface SecurityService {
	
	public String getCurrentUser();
	public String getUserFullName();
	public String getUserIpAddress();
	public SessionData getSessionData();
	public void setSessionData(SessionData sessionData);
	public boolean getIsUserLoggedIn();
}
