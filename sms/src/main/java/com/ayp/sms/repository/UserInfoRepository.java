package com.ayp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.UserInfo;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>{
	
	@Query("select user from UserInfo user where user.userName=?1")
	UserInfo getUser(String userName);

}
