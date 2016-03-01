package com.ayp.sms.controllers;

import static com.ayp.sms.util.AppConstants.SUCCESS;
import static com.ayp.sms.util.AppConstants.FAILURE;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ayp.sms.dto.EmployeeDTO;
import com.ayp.sms.dto.ReasonDTO;
import com.ayp.sms.dto.ResponseObject;
import com.ayp.sms.dto.ValidationStatusDTO;
import com.ayp.sms.service.EmployeeService;
import com.ayp.sms.service.SecurityService;
import com.ayp.sms.util.ResponseUtil;
import com.ayp.sms.validation.EmployeeValidation;


/**
 * 
 * @author rana
 *
 */

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private SecurityService securityService;
	
	@RequestMapping(value = "/myschool/newEmployee", method = RequestMethod.GET)
	public String newEmployee(Locale locale, Model model){
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmployeeTypeList(employeeService.getEmployeeTypeList());
		dto.setQualificationList(employeeService.getQualificationList());
		model.addAttribute("dto", dto);
		return "school/newEmployee";
	}
	
	@ResponseBody
	@RequestMapping(value = "/myschool/createEmployee", method = RequestMethod.POST)
	public ResponseObject createNewEmployee(EmployeeDTO dto, HttpServletRequest request, HttpServletResponse response){
		ValidationStatusDTO validation = EmployeeValidation.validateNewEmployee(dto);
		if(!validation.isValidated())
			return ResponseUtil.createResponseObject(FAILURE, validation.getValidationMessage(), null);
		String message = employeeService.createNewEmployee(dto);
		return ResponseUtil.createResponseObject(SUCCESS, message, null);
	}
	
	@RequestMapping(value = "/myschool/getAllEmployees", method = RequestMethod.GET)
	public String getAllEmployees(Locale locale, Model model){
		model.addAttribute("empList", employeeService.getAllEmployees(securityService.getCampusId()));
		return "school/listAllEmployees";
	}
	
	@ResponseBody
	@RequestMapping(value = "/myschool/terminateAnEmployee", method = RequestMethod.POST)
	public ResponseObject terminateAllEmployees(@RequestBody ReasonDTO dto){
		return ResponseUtil.createResponseObject(SUCCESS, "", null);
	}

}
