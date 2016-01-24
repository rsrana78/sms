package com.ayp.sms.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.ayp.sms.domain.SessionData;

@Service("securityService")
@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
public class SecurityServiceImpl implements SecurityService{
	
	private SessionData sessionData = new SessionData();
	
	@Override
	public String getCurrentUser() {
		return sessionData.getUserName();
	}
	
	@Override
	public String getUserFullName() {
		return sessionData.getFullName();
	}

	@Override
	public String getUserIpAddress () {
		return sessionData.getUserIp();
	}

	@Override
	public SessionData getSessionData() {
		return sessionData;
	}

	@Override
	public void setSessionData(SessionData sessionData) {
		this.sessionData = sessionData;
	}

	@Override
	public boolean getIsUserLoggedIn() {
		if(getCurrentUser() != null && !getCurrentUser().isEmpty())
			return true;
		else
			return false;
	}
}
