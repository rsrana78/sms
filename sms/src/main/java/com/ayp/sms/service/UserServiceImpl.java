package com.ayp.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.UserInfo;
import com.ayp.sms.repository.UserInfoRepository;

@Repository
@Service("UserService")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserInfoRepository userInfoRepository;

	@Override
	public UserInfo getUserInfo(String userName) {
		UserInfo user = userInfoRepository.findOne(1);
		return user;
	}

}
