package com.ayp.sms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ayp.sms.service.CampusService;

/**
 * 
 * @author rana
 *
 */

@Controller
public class CampusController {
	
	@Autowired
	private CampusService campusService;
	
	@RequestMapping(value = "getUserCampus", method = RequestMethod.GET)
	@ResponseBody
	public String getCampus(){
		return "user campus are";
	}

}
