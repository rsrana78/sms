package com.ayp.sms.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.dto.LoginUserDTO;

/**
 * 
 * @author rana
 *
 */

@Service
@Repository
@Transactional(rollbackFor = Exception.class)
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private SecurityService securityService;

	@Override
	public boolean loginUser(LoginUserDTO dto) throws Exception{
		Subject currentUser = SecurityUtils.getSubject();
		if(!currentUser.isAuthenticated()){
			UsernamePasswordToken token = new UsernamePasswordToken(dto.getUserName(), dto.getPassword());
			currentUser.login(token);
			securityService.getSessionData().setUserName(dto.getUserName());
			securityService.getSessionData().setFullName("Rana Rashid");
			return true;
		}
		return false;
	}

}
