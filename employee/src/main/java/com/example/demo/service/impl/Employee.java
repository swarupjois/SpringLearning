package com.example.demo.service.impl;

public class Employee {

	private String name;
	private int id;
	private String email;
	private int mobile;
	private String jobTitle;
	private String address;
	private int salary;
	private String dob;
	private String gender;
	private String bloodGroup;

	/*public Employee(int id, String name, String email, int mobile, String job, String address, int salary, String dob,
			String gender, String bg) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.jobTitle = job;
		this.address = address;
		this.salary = salary;
		this.dob = dob;
		this.gender = gender;
		this.bloodGroup = bg;

	}
*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", email=" + email + ", mobile=" + mobile + ", jobTitle="
				+ jobTitle + ", address=" + address + ", salary=" + salary + ", dob=" + dob + ", gender=" + gender
				+ ", bloodGroup=" + bloodGroup + "]";
	}
}
