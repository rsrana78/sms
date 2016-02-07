package com.ayp.sms.service;

import com.ayp.sms.dto.LoginUserDTO;

/**
 * 
 * @author rana
 *
 */

public interface LoginService {
	
	public boolean loginUser(LoginUserDTO dto) throws Exception;

}
