package com.ayp.sms.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.dao.StudentDAO;
import com.ayp.sms.domain.ClassDetail;
import com.ayp.sms.domain.Sections;
import com.ayp.sms.domain.Student;
import com.ayp.sms.domain.UserInfo;
import com.ayp.sms.dto.NewRecordCreatedDTO;
import com.ayp.sms.dto.StudentDetailDTO;
import com.ayp.sms.dto.StudentFilterDTO;
import com.ayp.sms.dto.StudentListingDTO;
import com.ayp.sms.dto.StudentRegistrationDTO;
import com.ayp.sms.exceptionHandling.RecordNotFoundException;
import com.ayp.sms.repository.CampusRepository;
import com.ayp.sms.repository.ClassDetailRepository;
import com.ayp.sms.repository.EmployeeRepository;
import com.ayp.sms.repository.SectionsRepository;
import com.ayp.sms.repository.StudentClassGroupRepository;
import com.ayp.sms.repository.StudentRepository;
import com.ayp.sms.repository.UserInfoRepository;
import com.ayp.sms.util.DomainMapper;

/**
 * 
 * @author rana
 *
 */

@Service("StudentService")
@Transactional(rollbackFor = Exception.class)
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentClassGroupRepository groupRepository;
	
	@Autowired
	private SectionsRepository sectionsRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private CampusRepository campusRepository;
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private ClassDetailRepository classDetailRepository;

	@Override
	public NewRecordCreatedDTO createNewStudent(StudentRegistrationDTO dto) {
		NewRecordCreatedDTO newRecord = new NewRecordCreatedDTO();
		newRecord.setCreated(true);
		Sections section = sectionsRepository.findOne(dto.getClassId());
		if(section == null){
			newRecord.setCreated(false);
			newRecord.setMessage("Please Select a valid class");
			return newRecord;
		}
		if(section.getSchoolClass().getStudentClassGroups().size()>0){
			if(dto.getClassGroup() == null || dto.getClassGroup() == 0){
				newRecord.setCreated(false);
				newRecord.setMessage("Please Select class group for new student");
				return newRecord;
			}
		}
		Integer checkStudentExist = studentRepository.checkStudentExist(dto.getName(), dto.getFatherName(), dto.getFatherCNIC());
		if(checkStudentExist.compareTo(0) == 1){
			newRecord.setCreated(false);
			newRecord.setMessage("Student with given details already exists. Please view active or non-active student list page.");
			return newRecord;
		}
		Student student = DomainMapper.createStudent(dto);
		student.setAdmissionBy(employeeRepository.findOne(securityService.getCurrentUserId()));
		student.setCampus(campusRepository.findOne(securityService.getSchoolId()));
		student.setRegistrationNumber(studentDAO.getRegistrationNumber(securityService.getSchoolId()));
		student.setSection(section);
		if(dto.getClassGroup() != null)
			student.setClassGroup(groupRepository.findOne(dto.getClassGroup()));
		student = studentRepository.save(student);
		//Student saved. Now create an entry into class-detail table also
		ClassDetail classDetail = new ClassDetail();
		classDetail.setActive(true);
		classDetail.setSection(section);
		classDetail.setStudent(student);
		classDetail.setRollNumber(studentDAO.getRollNumber(section.getId()));
		classDetailRepository.save(classDetail);
		//Create an entry for user-info so student can login
		UserInfo user = DomainMapper.createUserInfo(dto, student.getRegistrationNumber());
		user.setStudent(student);
		Sha256Hash encryptedPassword = new Sha256Hash(dto.getContactNumber());
		user.setPassword(encryptedPassword.toHex());
		userInfoRepository.save(user);
		return newRecord;
	}

	@Override
	public List<StudentListingDTO> getActiveStudentsOfClass(StudentFilterDTO filter) {
		if(filter.getClassId() == null){
			filter.setClassId(securityService.getClassId());
		}
		if(filter.getClassId() == null){
			return null;
		}
		List<StudentListingDTO> studentDTOList = new ArrayList<>();
		List<Student> studentList = null;
		if((filter.getGender() == null || filter.getGender().trim().isEmpty())&& filter.getGrooupId() == null){
			studentList = studentRepository.getActiveStudentsOfClass(filter.getClassId());
		}else{
			studentList = studentDAO.getFilteredStudents(filter);
		}
		for(Student student:studentList){
			studentDTOList.add(DomainMapper.createStudentListingDTO(student));
		}
		return studentDTOList;
	}

	@Override
	public List<StudentListingDTO> getInactiveStudentsOfSchool(StudentFilterDTO filter) {
		filter.setSchoolId(securityService.getSchoolId());
		if(filter.getSchoolId() == null){
			return null;
		}
		List<StudentListingDTO> studentDTOList = new ArrayList<>();
		List<Student> studentList = null;
		if((filter.getGender() == null || filter.getGender().trim().isEmpty())&& filter.getGrooupId() == null){
			studentList = studentRepository.getInActiveStudentsOfSchool(filter.getSchoolId());
		}else{
			studentList = studentDAO.getFilteredStudents(filter);
		}
		for(Student student:studentList){
			studentDTOList.add(DomainMapper.createStudentListingDTO(student));
		}
		return studentDTOList;
	}
	
	@Override
	public List<StudentListingDTO> getPassedoutStudentsOfSchool(StudentFilterDTO filter) {
		filter.setSchoolId(securityService.getSchoolId());
		if(filter.getSchoolId() == null){
			return null;
		}
		List<StudentListingDTO> studentDTOList = new ArrayList<>();
		List<Student> studentList = null;
		if((filter.getGender() == null || filter.getGender().trim().isEmpty())&& filter.getGrooupId() == null){
			studentList = studentRepository.getPassedOutStudentsOfSchool(filter.getSchoolId());
		}else{
			studentList = studentDAO.getFilteredStudents(filter);
		}
		for(Student student:studentList){
			studentDTOList.add(DomainMapper.createStudentListingDTO(student));
		}
		return studentDTOList;
	}

	@Override
	public StudentDetailDTO getStudentDetail(String regNumber) {
		Student student = studentRepository.getStudentForDetail(regNumber, securityService.getSchoolId());
		if(student == null){
			throw new RecordNotFoundException("No Data Found For Selected Student");
		}
		return DomainMapper.createStudentDetailDTO(student);
	}

}
