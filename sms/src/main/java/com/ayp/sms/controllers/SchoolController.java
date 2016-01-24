package com.ayp.sms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author rana
 *
 */

@Controller
public class SchoolController {
	
	@RequestMapping(value = "/myschool", method = RequestMethod.GET)
	public String getYourHomePage(){
		return "school/index";
	}

}
