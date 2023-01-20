package com.prowings.empcrudrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prowings.empcrudrest.model.Employee;
import com.prowings.empcrudrest.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public @ResponseBody String saveEmployee(@RequestBody Employee employee)
	{
		
		service.saveEmployee(employee);
		
		return "Sucessfully Stored";
	}
	
	@GetMapping(value = "/employees/{id}")
	public @ResponseBody Employee getEmployee(@PathVariable("id") int id)
	{
		Employee emp;
		emp = service.getEmployeeById(id);
		
		return emp;
	}
	
	@GetMapping(value ="/employees")
	public @ResponseBody List<Employee> getAllEmployees()
	{
		List<Employee> ls = service.getAllEmployees();
		return ls;
	}
	
	@DeleteMapping(value = "/employees/{id}")
	public @ResponseBody  String deleteEmployeeByID(@PathVariable ("id") int id)
	{
		
		service.deleteEmployeeByID(id);
		
		return " Object Deleted sucessfully";
	}
	
	
}
