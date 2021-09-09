package com.stc.manager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private Double Salary;
	private Long DepartmentId;
}
