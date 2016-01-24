package com.ayp.sms.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ayp.sms.dto.ContactUsDTO;
import com.ayp.sms.dto.ResponseObject;
import com.ayp.sms.service.ContactUsService;
import com.ayp.sms.util.ResponseUtil;

import static com.ayp.sms.util.AppConstants.SUCCESS;
import static com.ayp.sms.util.AppConstants.FAILURE;

/**
 * 
 * @author rana
 *
 */

@Controller
public class ContactUsController {
	
	@Autowired
	private ContactUsService contactUsService;
	
	@RequestMapping(value = "/contactUs", method = RequestMethod.POST)
	@ResponseBody
	public ResponseObject createContactUsRequest(@RequestBody ContactUsDTO dto, HttpServletRequest request){
		if(contactUsService.createContactUsRequest(dto))
			return ResponseUtil.createResponseObject(SUCCESS, "Your request has been sent to Admin."
					+ " Please wiat for your email reply", null);
		return ResponseUtil.createResponseObject(FAILURE, "Please try again", null);
	}

}
