package com.stc.manager.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stc.manager.model.Department;
import com.stc.manager.model.DepartmentDetails;
import com.stc.manager.model.Employee;
import com.stc.manager.model.Manager;
import com.stc.manager.model.ManagerDetails;
import com.stc.manager.repository.ManagerRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ManagerService {

	@Autowired
	ManagerRepo managerRepo;
	@Autowired
	DepartmentFeignClient departmentFeignClient;
	@Autowired
	EmployeeFeignClient employeeFeignClient;

	public Manager saveManager(Manager manager) {
		log.info("saveManager methode in ManagerService");
		return managerRepo.save(manager);
	}
/* return manager and his department */
	public ManagerDetails getMangerDetails(long id) {
		log.info("getMangerDetails methode in ManagerService");
		Manager manager = getManagerbyId(id);
		Department department = getDepartment(manager.getDepartmentId());

		return new ManagerDetails(manager, department);

	}

	/* return all information about manager department */
	public DepartmentDetails getDepartmentDetails(long managerId) {
		log.info("DepartmentDetails methode in ManagerService");

		Manager manager = managerRepo.getById(managerId);
		Department department = getDepartment(manager.getDepartmentId());
		List<Employee> employees = employeeFeignClient.getEmployeesByDepartmentId(department.getDepartmentId());
		long salariesCount = countEmployeesSalaries(employees);

		long employeesNum = employees.size();
		DepartmentDetails departmentDetails = new DepartmentDetails(department,employees,salariesCount,employeesNum);
		return departmentDetails;

	}

	
	public Manager getManagerbyId(Long id) {
		log.info("getManagerbyId methode in ManagerService");

		Manager manager = managerRepo.getById(id);
		return manager;
	}

	public Department getDepartment(long id) {
		log.info("getDepartment methode in ManagerService");

		Department department = departmentFeignClient.getDepartmentById(id);
		return department;

	}

	public List<Employee> getEmployeesByDepartmentId(Long deptId) {
		return employeeFeignClient.getEmployeesByDepartmentId(deptId);
	}

	public Long countEmployeesSalaries(List<Employee> employees) {
		long salariesCount = 0;
		Iterator<Employee> it = employees.iterator();
		while (it.hasNext()) {
			Employee employee = (Employee) it.next();
			salariesCount += employee.getSalary();
		}
		return salariesCount;

	}

}
