package com.ayp.sms.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ayp.sms.domain.SessionData;
import com.ayp.sms.service.SecurityService;
import com.ayp.sms.service.UserService;

public class AuthenticationInterceptor implements HandlerInterceptor{
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserService userService;
	
    
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)	throws Exception {}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,Object arg2, ModelAndView arg3) throws Exception {}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		SessionData sessionData = securityService.getSessionData();
		if(sessionData == null){
			/**
	         * Set Session Data
	         */
	        sessionData = new SessionData();
	        String ip = request.getRemoteAddr();
			if (ip.contains("127.0.0.1") || ip.contains("0:0:0:0:0:0:0:1")) {
				String xforward = request.getHeader("X-Forwarded-For");
				if (xforward != null) {
					ip = xforward;
					if (ip.contains(",")) {
						ip = ip.substring(ip.indexOf(','));
					}

				}
			}
			sessionData.setUserIp(ip);
			securityService.setSessionData(sessionData);
		}
		return true;
	}

}
