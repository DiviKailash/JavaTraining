package com.dal;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.dal.controller.*;


import com.dal.controller.EmployeeController;

public class MainClass  {

	static int y = 89; // Class Variable
	int z = 100;
	String emp = "divya";
	

	
	public static void main(String[] args) throws IOException {		
		String uname = null;
		String pwd = null;
		try {			
			System.out.println("Welcome");			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Enter Uname:");
			uname = br.readLine();
			System.out.println("Enter pwd:");
			pwd = br.readLine();
			if (uname.equals("divya") && pwd.equals("divya")) {
				System.out.println("Welcome " + uname);
				EmployeeController ec = new EmployeeController();
				Scanner sc = new Scanner(System.in);
				String choice = null;
				List<Employee> emp = new ArrayList<Employee>();
				
				do {
					System.out.println("Enter your choice");
					System.out.println("1. Add Employee");
					System.out.println("2. View Employee");
					System.out.println("3. Serialize Employees");
					System.out.println("4. DeSerialize Employees");
					System.out.println("5. Sort Emp by ID");
					System.out.println("6. Sort by Emp name");
					System.out.println("7. update data");
					System.out.println("8. Delete data");
					int ch = sc.nextInt();
					switch (ch) {
					case 1: {
						ec.addEmployee();
						emp = ec.empList;
						break;
					}
					case 2: {
						ec.viewEmployee();
						break;
					}
					case 3:
					{
						ec.serialize(emp);
						System.out.println(emp);
						break;
					}
					case 4:
					{
						ec.deserilalize();
						break;
					}
					case 5: {
						ec.sortByEid();
						break;
					}
					case 6: {
						ec.sortByEname();
						break;
					}
					case 7: {
						ec.updateEmployee();
						break;
					}
					case 8: {
						ec.deleteEmployee();
						break;
					}
					default: {
						System.out.println("Enter right choice");
						break;
					}
					}
					System.out.println("Do u want to continue Y or y");
					choice = sc.next();
				} while (choice.equals("Y") || choice.equals("y"));
				System.out.println("Exited");
				System.exit(0);
			} 
			else {
				throw new UserNotFound(uname);
			}
		}
		 catch (UserNotFound unf) {
			System.out.println(unf);
		}

		finally {

		}
	}

}
