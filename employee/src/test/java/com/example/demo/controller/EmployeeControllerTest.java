package com.example.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.service.EmployeeService;
import com.example.demo.service.impl.Employee;

import wiremock.com.google.common.io.Files;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private EmployeeService empService;

	@Test
	public void getAllEmployeeTest() throws Exception {
		String expected = Files.toString(new ClassPathResource("test.json").getFile(), Charset.forName("UTF-8"));
		given(empService.getAllEmployee()).willReturn(getAllEmployeeMock());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employees").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mvc.perform(requestBuilder).andReturn();
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);

	}

	@Test
	public void getEmployeeTest() throws Exception {
		String expected = Files.toString(new ClassPathResource("test_emp_id.json").getFile(),
				Charset.forName("UTF-8"));
		given(empService.getEmployeeById()).willReturn(getEmployeeByIdMock());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employees/101").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mvc.perform(requestBuilder).andReturn();
		System.out.println("Result of mvc response:" + result.getResponse().getContentAsString());
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);

	}
	
	@Test
	public void getCreateEmployeeTest() throws Exception {
		given(empService.createEmployee()).willReturn(getCreateEmployeeMock());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/employees/add").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mvc.perform(requestBuilder).andReturn();
		//System.out.println("Result of mvc response:" + result.getResponse().getContentAsString());
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

	}


	@SuppressWarnings("unchecked")
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
		System.out.println("mock contraoller"+allEmployee);

		return allEmployee;
	}

	@SuppressWarnings("unchecked")
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
	public String getCreateEmployeeMock() {
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
