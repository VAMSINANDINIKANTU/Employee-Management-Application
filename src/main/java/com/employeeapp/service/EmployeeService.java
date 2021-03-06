package com.employeeapp.service;
import java.util.List;
import java.util.Optional;

import com.employeeapp.entities.Employee;
public interface EmployeeService {
	 public Optional<Employee> findEmployeeById(Long id);
	 public List<Employee>findBySalaryGreaterThan(double salary);
}