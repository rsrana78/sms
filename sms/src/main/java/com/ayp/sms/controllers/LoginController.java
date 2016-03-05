package com.ayp.sms.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ayp.sms.dto.LoginUserDTO;
import com.ayp.sms.dto.ResponseObject;
import com.ayp.sms.service.LoginService;
import com.ayp.sms.service.SecurityService;
import com.ayp.sms.util.ResponseUtil;

import static com.ayp.sms.util.AppConstants.SUCCESS;
import static com.ayp.sms.util.AppConstants.FAILURE;

/**
 * 
 * @author rana
 *
 */

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private SecurityService securityService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseObject loginUser(@RequestBody LoginUserDTO dto, HttpServletRequest request, HttpServletResponse response){
		try{
			if(loginService.loginUser(dto))
				return ResponseUtil.createResponseObject(SUCCESS, "Login Successfull", null);
			else
				return ResponseUtil.createResponseObject(FAILURE, "Username or Password is incorrect. Try again", null);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseUtil.createResponseObject(FAILURE, "Username or Password is incorrect. Try again", null);
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logoutUser(HttpServletRequest request, HttpServletResponse response) throws IOException{
		securityService.setSessionData(null);
		Subject currentUser = SecurityUtils.getSubject();
		if(currentUser.isAuthenticated())
			currentUser.logout();
		response.sendRedirect(request.getServletContext().getContextPath()+"/login");
	}

}
