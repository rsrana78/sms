package com.ayp.sms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ayp.sms.service.EmployeeService;

/**
 * 
 * @author rana
 *
 */

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

}
