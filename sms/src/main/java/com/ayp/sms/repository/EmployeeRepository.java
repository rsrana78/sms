package com.ayp.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ayp.sms.domain.Employee;

/**
 * 
 * @author rana
 *
 */

@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	@Query("select emp from Employee emp where emp.school.id=?1 and emp.serving=1")
	List<Employee> getAllEmployees(Integer campusId);
	
	@Query("select emp from Employee emp where emp.school.id=?1 and emp.serving=0")
	List<Employee> getAllTerminatedEmployees(Integer campusId);
	
	@Query("select emp from Employee emp where emp.cnic=?1")
	Employee getEmployeeFromCNIC(String cnic);

}
