package com.ayp.sms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.Campus;
import com.ayp.sms.domain.Student;
import com.ayp.sms.dto.StudentFilterDTO;
import com.ayp.sms.enums.GenderEnum;
import com.ayp.sms.repository.CampusRepository;

/**
 * 
 * @author rana
 *
 */

@Service("StudentDAO")
@Transactional(rollbackFor = Exception.class)
public class StudentDAOImpl implements StudentDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private CampusRepository campusRepository;
	
	@SuppressWarnings("unchecked")
	@Override
	public String getRegistrationNumber(Integer schoolId) {
		String registrationNumber = null;
		String sql = "select registrationNumber from students where school="+schoolId+" order by entryDate desc limit 1";
		Query query = entityManager.createNativeQuery(sql);
		List<String> regNumberList = (List<String>)query.getResultList();
		if(regNumberList != null && !regNumberList.isEmpty() && regNumberList.size()>0)
			registrationNumber = regNumberList.get(0);
		if(registrationNumber != null && !registrationNumber.trim().isEmpty()){
			String[] reg = registrationNumber.split("-");
			String schoolInitials = reg[0];
			String campusInitials = reg[1];
			Integer number = Integer.parseInt(reg[2]);
			number = number+1;
			String regNumber = null;
			if(number<10){
				regNumber = "00000000"+number;
			}else if(number<100){
				regNumber = "0000000"+number;
			}
			else if(number<1000){
				regNumber = "000000"+number;
			}
			else if(number<10000){
				regNumber = "00000"+number;
			}
			else if(number<100000){
				regNumber = "0000"+number;
			}
			else if(number<1000000){
				regNumber = "000"+number;
			}
			else if(number<10000000){
				regNumber = "00"+number;
			}
			else if(number<100000000){
				regNumber = "0"+number;
			}else{
				regNumber = number.toString();
			}
			registrationNumber = schoolInitials+"-"+campusInitials+"-"+regNumber;
		}else{
			Campus campus = campusRepository.findOne(schoolId);
			if(campus != null){
				String schoolInitials = campus.getSchool().getSchoolInitials();
				String campusInitials = campus.getCampusInitials();
				registrationNumber = schoolInitials+"-"+campusInitials+"-000000001";
			}
		}
		return registrationNumber;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer getRollNumber(Integer sectionId) {
		String sql = "select class.rollNumber from schoolClassDetail class inner join students student "
					+"on class.student=student.registrationNumber where student.class="+sectionId
					+"order by student.entryDate DESC limit 1";
		Query query = entityManager.createNativeQuery(sql);
		List<Integer> rollNumberList = (List<Integer>)query.getResultList();
		if(rollNumberList != null && !rollNumberList.isEmpty() && rollNumberList.size()>0)
			return rollNumberList.get(0)+1;
		else
			return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getFilteredStudents(StudentFilterDTO filter) {
		String query = "select student from Student student where";
		StringBuilder subQuery = new StringBuilder();
		if(filter.getClassId() != null){
			subQuery.append(" student.section.id="+filter.getClassId());
		}
		if(filter.getClassId() != null && filter.getSchoolId() != null){
			subQuery.append(" and");
		}
		if(filter.getSchoolId() != null){
			subQuery.append(" student.campus.id="+filter.getSchoolId());
		}
		if(!filter.isInActive()){//only active students
			subQuery.append(" and student.admissionCancel=0 and student.hasLeft=0 and student.passedOut=0");
		}
		if(filter.isInActive()){//only inactive students
			subQuery.append(" and student.admissionCancel=1 and student.hasLeft=1 and student.passedOut=0");
		}
		if(filter.isPassout()){//only passed out students
			subQuery.append(" and student.admissionCancel=0 and student.hasLeft=0 and student.passedOut=1");
		}
		if(filter.getGender() != null && !filter.getGender().trim().isEmpty()){
			subQuery.append(" and student.gender="+GenderEnum.getGenderId(filter.getGender()));
		}
		if(filter.getGrooupId() != null){
			subQuery.append(" and student.classGroup.id="+filter.getGrooupId());
		}
		Query hql = entityManager.createQuery(query + subQuery);
		List<Student> studentList = (List<Student>)hql.getResultList();
		return studentList;
	}

}
