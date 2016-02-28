package com.ayp.sms.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.SessionData;
import com.ayp.sms.domain.UserInfo;
import com.ayp.sms.dto.LoginUserDTO;
import com.ayp.sms.enums.UserTypeEnum;
import com.ayp.sms.repository.UserInfoRepository;

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
	
	@Autowired
	private UserInfoRepository userInfoRepository;

	@Override
	public boolean loginUser(LoginUserDTO dto) throws Exception{
		Subject currentUser = SecurityUtils.getSubject();
		if(!currentUser.isAuthenticated()){
			UsernamePasswordToken token = new UsernamePasswordToken(dto.getUserName(), dto.getPassword());
			currentUser.login(token);
			UserInfo user = userInfoRepository.getUser(dto.getUserName());
			SessionData sessionData = securityService.getSessionData();
			sessionData.setUserName(dto.getUserName());
			sessionData.setFullName(user.getFullName());
			if(user.isStudent())
				sessionData.setUserType(UserTypeEnum.STUDENT.getType());
			else if(user.isSuperUser())
				sessionData.setUserType(UserTypeEnum.ADMIN.getType());
			else if(user.getEmployee() != null)
				sessionData.setUserType(UserTypeEnum.EMPLOYEE.getType());
			else
				sessionData.setUserType(UserTypeEnum.PRINCIPAL.getType());
			//TODO set real school data
			//also make foreign keys for campus and user in userinfo
			//set real logo path from database
			sessionData.setSchoolId(user.getSchool());
			sessionData.setCampusId(user.getSchoolCampus());
			sessionData.setSchoolName(user.getSchool().toString());
			sessionData.setCampusName(user.getSchoolCampus().toString());
			sessionData.setImagePath("/images/monograms/a.png");
			securityService.setSessionData(sessionData);
			return true;
		}
		return false;
	}

}
