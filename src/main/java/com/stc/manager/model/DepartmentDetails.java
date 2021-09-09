package com.stc.manager.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDetails {
	private Department department;
	private List<Employee> employees;
	private long salaryCount;
	private long employeesNum;
}
