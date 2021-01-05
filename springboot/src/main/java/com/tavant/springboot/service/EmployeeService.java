package com.tavant.springboot.service;

import java.util.List;
import java.util.Optional;

import com.tavant.springboot.exceptions.InvalidNameException;
import com.tavant.springboot.exceptions.InvalidSalaryException;
import com.tavant.springboot.model.Employee;

public interface EmployeeService {
	public boolean addEmployee(Employee emp);
	public Optional<Employee> updateEmployee(Integer empId , Employee employee) 
			throws InvalidSalaryException , InvalidNameException;
	public Optional<List<Employee>> getEmployees();
	public Optional<Employee> deleteEmploye(Integer empid);
	public Optional<Employee> getEmployeeById(Integer empid);
	public boolean isExists(Integer empId);
}
