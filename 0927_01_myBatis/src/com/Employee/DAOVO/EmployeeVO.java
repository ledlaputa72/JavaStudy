package com.Employee.DAOVO;

import java.sql.Date;
import java.util.*;

public class EmployeeVO {
	
	private int employee_id;
	private String first_name;
	private String last_name;
	private String email;
	
	//getter setter 
	private String phone_number;
	private String hire_date;
	private int salary;
	private String job_id;
	
	public EmployeeVO() {
		
	}
	
	public EmployeeVO(int employee_id, String first_name, String last_name, String email, String phone_number,
			String hire_date, int salary, String job_id) {
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone_number = phone_number;
		this.hire_date = hire_date;
		this.salary = salary;
		this.job_id = job_id;
	}
	
	public EmployeeVO(String first_name, String last_naem, int salary, int employee_id) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.salary = salary;
		this.employee_id = employee_id;
	}
	
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	
	
}
