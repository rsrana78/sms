package com.ayp.sms.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.Employee;
import com.ayp.sms.domain.Sections;
import com.ayp.sms.domain.SessionData;
import com.ayp.sms.domain.Student;
import com.ayp.sms.domain.UserInfo;
import com.ayp.sms.dto.LoginUserDTO;
import com.ayp.sms.enums.UserTypeEnum;
import com.ayp.sms.repository.SectionsRepository;
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
	
	@Autowired
	private SectionsRepository sectionRepository;

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
			if(user.getEmployee() != null){
				sessionData.setUserId(user.getEmployee().getEmployeeId());
				Employee employee = user.getEmployee();
				sessionData.setCampusId(employee.getCampuses().getId());
				sessionData.setCampusName(employee.getCampuses().getCampusName());
				Sections section = sectionRepository.getSectionByIncharge(employee.getEmployeeId());
				if(section != null)
					sessionData.setClassId(section.getId());
				sessionData.setImagePath(CompleteURLUtil.completeURL(employee.getCampuses().getMonogram()));
			}else{
				Student student = user.getStudent();
				sessionData.setCampusId(student.getCampus().getId());
				sessionData.setCampusName(student.getCampus().getCampusName());
				sessionData.setImagePath(CompleteURLUtil.completeURL(student.getCampus().getMonogram()));
			}
			if(user.getStudent() != null)
				sessionData.setUserType(UserTypeEnum.STUDENT.getType());
			else if(user.getEmployee() != null)
				sessionData.setUserType(UserTypeEnum.EMPLOYEE.getType());
			else
				sessionData.setUserType(UserTypeEnum.ADMIN.getType());
			securityService.setSessionData(sessionData);
			return true;
		}
		return false;
	}

}
