package com.ayp.sms.controllers;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ayp.sms.dto.ResponseObject;
import com.ayp.sms.service.ClassSectionsService;
import com.ayp.sms.service.SecurityService;
import com.ayp.sms.util.ResponseUtil;

import static com.ayp.sms.util.AppConstants.SUCCESS;

/**
 * 
 * @author rana
 *
 */

@Controller
public class ClassSectionsController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ClassSectionsService classSectionsService;
	
	@Autowired
	private SecurityService securityService;
	
	
	@RequestMapping(value = "/myschool/getAllClasses", method = RequestMethod.GET)
	@ResponseBody
	public ResponseObject getAllClasses(){
		return ResponseUtil.createResponseObject(SUCCESS, null, classSectionsService.getAllClasses(securityService.getSchoolId()));
	}
	
	@RequestMapping(value = "/myschool/getClassSections/{classId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseObject getClassSections(@PathVariable Integer classId){
		return ResponseUtil.createResponseObject(SUCCESS, null, classSectionsService.getAllSections(classId));
	}
	
	@RequestMapping(value = "/myschool/getClassGroups/{classId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseObject getClassGroups(@PathVariable Integer classId){
		return ResponseUtil.createResponseObject(SUCCESS, null, classSectionsService.getAllGroups(classId));
	}

}
