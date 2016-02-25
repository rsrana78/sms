package com.ayp.sms.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ayp.sms.dto.ResponseObject;
import com.ayp.sms.service.SchoolService;
import com.ayp.sms.util.ResponseUtil;

import static com.ayp.sms.util.AppConstants.SUCCESS;
/**
 * 
 * @author rana
 *
 */

@Controller
public class SchoolController {
	
	@Autowired
	private SchoolService schoolService;
	
	@RequestMapping(value = "/myschool", method = RequestMethod.GET)
	public String getYourHomePage(Locale locale, Model model){
		//TODO Add logo and school name dynamically
		model.addAttribute("logoPath","/images/monograms/a.png");
		model.addAttribute("schoolName","Its My Test School Name");
		return "school/schoolindex";
	}
	
	@RequestMapping(value="/getAllRegisteredSchools", method = RequestMethod.GET)
	@ResponseBody
	public ResponseObject getAllSchools(){
		return ResponseUtil.createResponseObject(SUCCESS, null, schoolService.getAllRegisteredSchool());
	}

}
