package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.EmployeeService;
import com.example.demo.service.impl.Employee;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService empService;

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public List<Employee> getAllEmployee() {
		return empService.getAllEmployee();
	}

	@RequestMapping(value = "/employees/101", method = RequestMethod.GET)
	public Employee getEmployeeById() {
		return empService.getEmployeeById();
	}

	@RequestMapping(value = "/employees/add", method = { RequestMethod.POST, RequestMethod.GET })
	public String createEmployee() {
		return empService.createEmployee();
	}
}
