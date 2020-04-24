package com.employeeapp.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeapp.entities.Employee;
import com.employeeapp.repository.EmployeeRepository;
@Service
@Transactional
public class EmployeeServiceImplementation implements EmployeeService{
	@Autowired
	private EmployeeRepository employeerepository;
    @Override
	public Optional<Employee> findEmployeeById(Long id) {
		return employeerepository.findEmployeeById(id);
	}
	
	  @Override
	  public List<Employee> findBySalaryGreaterThan(double salary) {
	    return employeerepository.findBySalaryGreaterThan(salary); }
	 
}
