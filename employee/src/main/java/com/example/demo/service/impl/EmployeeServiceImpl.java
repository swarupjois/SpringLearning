package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private RestTemplate restTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployee() {
		// RestTemplate restTemplate = new RestTemplate();
		List<Employee> response = restTemplate.getForObject("http://localhost:3000/employees", List.class);
		return response;
	}

	@Override
	public Employee getEmployeeById() {
		// RestTemplate restTemplate = new RestTemplate();
		Employee response = restTemplate.getForObject("http://localhost:3000/employees/101", Employee.class);
		// System.out.println("Employee data is " + response.toString());
		return response;
	}

	@Override
	public String createEmployee() {
		// RestTemplate restTemplate = new RestTemplate();
		Employee newEmployee = new Employee();
		newEmployee.setId(0);
		newEmployee.setName("name");
		newEmployee.setEmail("email");
		newEmployee.setMobile(8888);
		newEmployee.setJobTitle("job");
		newEmployee.setAddress("address");
		newEmployee.setSalary(5000);
		newEmployee.setDob("dob");
		newEmployee.setGender("gender");
		newEmployee.setBloodGroup("blood group");
		
		HttpEntity<?> request = new HttpEntity<>(newEmployee);
		ResponseEntity<?> response = restTemplate.postForEntity("http://localhost:3000/employees", request, String.class);
		// System.out.println(response.getBody().toString());
		return response.getBody().toString();

	}

}
