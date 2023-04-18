package com.dal.controller;


import java.io.IOException;
import java.util.List;

import com.dal.Employee;

public interface EmployeeInterface {
	
	
	public void addEmployee();
	public void viewEmployee();
	public void serialize(List<Employee> emplist)throws IOException;
	public void deserilalize() throws IOException;
	public void sortByEid();
	public void sortByEname();
}
