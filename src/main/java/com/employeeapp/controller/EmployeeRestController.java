package com.employeeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeapp.entities.Employee;
import com.employeeapp.exceptionhandler.EmployeeNotFoundException;
import com.employeeapp.service.EmployeeService;
@RestController
@RequestMapping(path="/myapi")
public class EmployeeRestController {
	@Autowired
	private EmployeeService employeeservice;
    public EmployeeRestController(EmployeeService employeeservice) {
		super();
		this.employeeservice = employeeservice;
	}
    @GetMapping(path = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getAnEmployee(@PathVariable(name = "id") Long id){
		Employee employee = employeeservice.findEmployeeById(id).orElseThrow(EmployeeNotFoundException::new);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
   @GetMapping(path="/employee/limit/{salary}",produces=MediaType. APPLICATION_JSON_VALUE) 
    public ResponseEntity<List<Employee>> getBySalaryGreaterThan(@PathVariable(name="salary")double salary){ 
    	return new ResponseEntity<List<Employee>>(employeeservice.findBySalaryGreaterThan(salary),HttpStatus.OK);
    }
}
