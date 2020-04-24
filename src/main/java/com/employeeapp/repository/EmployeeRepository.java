package com.employeeapp.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeapp.entities.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	 public Optional<Employee> findEmployeeById(Long id);
	 public List<Employee>findBySalaryGreaterThan(double salary);
}