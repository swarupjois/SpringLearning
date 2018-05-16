package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.service.impl.Employee;

@Service
public interface EmployeeService {
	public List<Employee> getAllEmployee();

	public Employee getEmployeeById();

	public String createEmployee();

}
