package com.stc.manager.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.stc.manager.model.Employee;

@FeignClient("employee-service/employees")
public interface EmployeeFeignClient {
	@GetMapping("/all/{deptId}")
	public List<Employee> getEmployeesByDepartmentId(@PathVariable long deptId);
}
