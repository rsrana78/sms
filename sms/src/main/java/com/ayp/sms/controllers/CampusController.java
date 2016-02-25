package com.ayp.sms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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

}
