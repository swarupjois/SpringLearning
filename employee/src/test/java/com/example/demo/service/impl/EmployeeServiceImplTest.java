package com.example.demo.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyObject;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.demo.service.EmployeeService;

import wiremock.com.google.common.io.Files;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplTest {

	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration {

		@Bean
		public EmployeeService employeeService() {
			return new EmployeeServiceImpl();
		}
	}

	@Autowired
	private EmployeeService empService;

	@MockBean
	RestTemplate restTemplate;

	@Test
	public void getAllEmployeeTest() throws IOException, JSONException {
		String uri = "http://localhost:3000/employees";
		given(restTemplate.getForObject(uri, List.class)).willReturn(getAllEmployeeMock());
		List<Employee> res = empService.getAllEmployee();
		// System.out.println("response:::" + res);
		assertEquals(getAllEmployeeMock().toString(), res.toString());

	}

	@Test
	public void getEmployeeByIdTest() throws IOException, JSONException {
		String uri = "http://localhost:3000/employees/101";
		given(restTemplate.getForObject(uri, Employee.class)).willReturn(getEmployeeByIdMock());
		Employee res = empService.getEmployeeById();
		assertEquals(getEmployeeByIdMock().toString(), res.toString());

	}

	@Test
	@Ignore
	public void CreateEmployeeTest() throws IOException, JSONException {
		String uri = "http://localhost:3000/employees/";
		Employee newEmployee = new Employee();
		newEmployee.setId(0);
		newEmployee.setName("newEmployee");
		newEmployee.setEmail("email");
		newEmployee.setMobile(8888);
		newEmployee.setJobTitle("job");
		newEmployee.setAddress("address");
		newEmployee.setSalary(5000);
		newEmployee.setDob("dob");
		newEmployee.setGender("gender");
		newEmployee.setBloodGroup("blood group");

		HttpEntity<?> request = new HttpEntity<>(newEmployee);
		given(restTemplate.postForObject(uri, request, String.class)).willReturn(CreateEmployeeMock());
		String res = empService.createEmployee();
		System.out.println("response:::" + res.toString());

		assertEquals(CreateEmployeeMock().toString(), res.toString());

	}

	private List<Employee> getAllEmployeeMock() {
		List<Employee> allEmployee = new LinkedList<Employee>();
		Employee employee_one = new Employee();
		employee_one.setId(111);
		employee_one.setName("name");
		employee_one.setEmail("email");
		employee_one.setMobile(8888);
		employee_one.setJobTitle("job");
		employee_one.setAddress("address");
		employee_one.setSalary(5000);
		employee_one.setDob("dob");
		employee_one.setGender("gender");
		employee_one.setBloodGroup("blood group");

		allEmployee.add(employee_one);

		Employee employee_two = new Employee();
		employee_two.setId(112);
		employee_two.setName("name");
		employee_two.setEmail("email");
		employee_two.setMobile(8888);
		employee_two.setJobTitle("job");
		employee_two.setAddress("address");
		employee_two.setSalary(5000);
		employee_two.setDob("dob");
		employee_two.setGender("gender");
		employee_two.setBloodGroup("blood group");

		allEmployee.add(employee_two);

		return allEmployee;
	}

	public Employee getEmployeeByIdMock() {
		Employee employee = new Employee();
		employee.setId(111);
		employee.setName("name");
		employee.setEmail("email");
		employee.setMobile(8888);
		employee.setJobTitle("job");
		employee.setAddress("address");
		employee.setSalary(5000);
		employee.setDob("dob");
		employee.setGender("gender");
		employee.setBloodGroup("blood group");

		return employee;
	}

	@SuppressWarnings("unchecked")
	public String CreateEmployeeMock() {
		Employee employee = new Employee();
		employee.setId(111);
		employee.setName("newEmployee");
		employee.setEmail("email");
		employee.setMobile(8888);
		employee.setJobTitle("job");
		employee.setAddress("address");
		employee.setSalary(5000);
		employee.setDob("dob");
		employee.setGender("gender");
		employee.setBloodGroup("blood group");

		return employee.toString();

	}

}
