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
import com.ayp.sms.util.CompleteURLUtil;

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
			try{
				currentUser.login(token);
			}catch(Exception e){
				return false;
			}
			UserInfo user = userInfoRepository.getUser(dto.getUserName());
			SessionData sessionData = securityService.getSessionData();
			sessionData.setUserName(dto.getUserName());
			sessionData.setFullName(user.getFullName());
			if(user.getSchoolCampus() != null){
				sessionData.setCampusId(user.getSchoolCampus().getId());
				sessionData.setCampusName(user.getSchoolCampus().getCampusName());
				sessionData.setImagePath(CompleteURLUtil.completeURL(user.getSchoolCampus().getMonogram()));
			}
			else if(user.getSchool() != null)
				sessionData.setImagePath(CompleteURLUtil.completeURL(user.getSchool().getMonogram()));
			else
				sessionData.setImagePath(CompleteURLUtil.completeURL(null));
			if(user.isSuperUser())
				sessionData.setUserType(UserTypeEnum.ADMIN.getType());
			else if(user.getStudent() != null)
				sessionData.setUserType(UserTypeEnum.STUDENT.getType());
			else if(user.getEmployee() != null)
				sessionData.setUserType(UserTypeEnum.EMPLOYEE.getType());
			else if(user.getSchool() == null && user.getSchoolCampus() != null)
				sessionData.setUserType(UserTypeEnum.PRINCIPAL.getType());
			else if(user.getSchool() != null && user.getSchoolCampus() == null)
				sessionData.setUserType(UserTypeEnum.OWNER.getType());
			securityService.setSessionData(sessionData);
			return true;
		}
		return false;
	}

}
