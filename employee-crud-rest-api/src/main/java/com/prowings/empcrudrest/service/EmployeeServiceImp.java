package com.prowings.empcrudrest.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prowings.empcrudrest.dao.EmployeeDao;
import com.prowings.empcrudrest.model.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	 EmployeeDao dao;
	@Override
	public void saveEmployee(Employee employee) {
		
		dao.saveEmployee(employee);
	}
	@Override
	public Employee getEmployeeById(int id) {
		
		return dao.getEmployeeById(id);
	}
	@Override
	public List<Employee> getAllEmployees() {
		
		return dao.getAllEmployees();
	}
	@Override
	public void deleteEmployeeByID(int id) {

		 dao.deleteEmployeeByID(id);		
	}

}
