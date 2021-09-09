package com.stc.manager.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.stc.manager.model.Department;

@FeignClient("department-service/departments")
public interface DepartmentFeignClient {
	@GetMapping("/{deptId}")
	public Department getDepartmentById(@PathVariable long deptId);
}
