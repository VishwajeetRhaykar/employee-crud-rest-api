package com.prowings.empcrudrest.dao;

import java.util.List;

import com.prowings.empcrudrest.model.Employee;

public interface EmployeeDao {

	public void saveEmployee(Employee employee);

	public Employee getEmployeeById(int id);

	public List<Employee> getAllEmployees();

	public void deleteEmployeeByID(int id);
}
