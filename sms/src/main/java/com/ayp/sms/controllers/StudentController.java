package com.ayp.sms.controllers;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ayp.sms.dto.NewRecordCreatedDTO;
import com.ayp.sms.dto.ResponseObject;
import com.ayp.sms.dto.StudentDetailDTO;
import com.ayp.sms.dto.StudentFilterDTO;
import com.ayp.sms.dto.StudentListingDTO;
import com.ayp.sms.dto.StudentRegistrationDTO;
import com.ayp.sms.dto.ValidationStatusDTO;
import com.ayp.sms.service.ClassSectionsService;
import com.ayp.sms.service.SecurityService;
import com.ayp.sms.service.StudentService;
import com.ayp.sms.util.ResponseUtil;
import com.ayp.sms.validation.StudentValidation;

import static com.ayp.sms.util.AppConstants.SUCCESS;
import static com.ayp.sms.util.AppConstants.FAILURE;
import static com.ayp.sms.util.ApplicationMessages.STUDENT_REGISTERED;

/**
 * 
 * @author rana
 *
 */

@Controller
public class StudentController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ClassSectionsService classSectionsService;
	
	@Autowired
	private SecurityService securityService;
	
	@RequestMapping(value = "/myschool/newAdmission", method = RequestMethod.GET)
	public String newStudentRegistration(Locale locale, Model model){
		model.addAttribute("classes", classSectionsService.getAllClasses(securityService.getSchoolId()));
		return "school/newStudent";
	}
	
	@RequestMapping(value = "/myschool/createNewStudent", method = RequestMethod.POST)
	@ResponseBody
	public ResponseObject createNewStudent(StudentRegistrationDTO student, HttpServletRequest request){
		ValidationStatusDTO validationDTO = StudentValidation.validateStudent(student);
		if(!validationDTO.isValidated()){
			return ResponseUtil.createResponseObject(FAILURE, validationDTO.getValidationMessage(), null);
		}
		NewRecordCreatedDTO record = studentService.createNewStudent(student);
		if(record.isCreated()){
			return ResponseUtil.createResponseObject(SUCCESS, STUDENT_REGISTERED, null);
		}else{
			return ResponseUtil.createResponseObject(FAILURE, record.getMessage(), null);
		}
	}
	
	@RequestMapping(value = "/myschool/listStudents", method = RequestMethod.GET)
	public String listStudentsPage(){
		return "school/listStudent";
	}
	
	@RequestMapping(value = "/myschool/listAllStudents", method = RequestMethod.POST)
	@ResponseBody
	public ResponseObject listAllStudents(@RequestBody StudentFilterDTO filter){
		List<StudentListingDTO> studentList = null;
		if(filter.isInActive())
			studentList = studentService.getInactiveStudentsOfSchool(filter);
		else if(!filter.isInActive() && !filter.isPassout())
			studentList = studentService.getActiveStudentsOfClass(filter);
		else if(filter.isPassout())
			studentList = studentService.getPassedoutStudentsOfSchool(filter);
		return ResponseUtil.createResponseObject(SUCCESS, null, studentList);
	}
	
	@RequestMapping(value = "/myschool/getStudentDetail/{regNumber}", method = RequestMethod.GET)
	public String getStudentDetail(@PathVariable String regNumber, Locale locale, Model model){
		StudentDetailDTO detail = studentService.getStudentDetail(regNumber);
		model.addAttribute("student", detail);
		return "dchool/studentDetail";
	}

}
