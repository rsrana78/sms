package com.ayp.sms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ayp.sms.service.SectionsService;

/**
 * 
 * @author rana
 *
 */

@Controller
public class SectionsController {
	
	@Autowired
	private SectionsService sectionsService;

}
