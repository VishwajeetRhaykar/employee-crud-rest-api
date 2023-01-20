package com.prowings.empcrudrest.service;

import java.util.List;

import com.prowings.empcrudrest.model.Employee;

public interface EmployeeService {
	
	public void saveEmployee(Employee employee);

	public Employee getEmployeeById(int id);

	public List<Employee> getAllEmployees();

	public void deleteEmployeeByID(int id);

}
