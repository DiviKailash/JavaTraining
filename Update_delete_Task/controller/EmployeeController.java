package com.dal.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.dal.Employee;
import java.io.*;
import com.dal.dao.EmployeeDao;
import com.dal.dao.EmployeeDaoImpl;


public class EmployeeController implements EmployeeInterface {

	
	Employee e;
	EmployeeDao dao = new EmployeeDaoImpl();
	public List<Employee> empList = new ArrayList<Employee>();
	public void addEmployee()
	{
		    e = new Employee();
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the ID: ");
	        int i = sc.nextInt();
	        
	        e.setEid(i);
	        System.out.println("Enter the Name: ");
	        String name = sc.next();
	        e.setEname(name);
	        empList.add(e);
	        dao.insertEmployee(e);
	        System.out.println("Employee Added Succesfully");

	}
	
	public void viewEmployee()
	{
//		Iterator i = empList.iterator();
//		while(i.hasNext()) {
//			System.out.println(i.next());
//		}
		dao.showEmployee();
	}
	
	public void deleteEmployee() {		   
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the ID: ");
	        int i = sc.nextInt();
		    dao.deleteEmployee(i);
	}
	
	public void updateEmployee() {
		    e = new Employee();
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the ID: ");
	        int i = sc.nextInt();
	        
	        e.setEid(i);
	        System.out.println("Enter the Name: ");
	        String name = sc.next();
	        e.setEname(name);
		dao.updateEmployee(e);
	}
	public void serialize(List<Employee> emplist) throws IOException{
		try {
			
			
			FileOutputStream fos = new FileOutputStream("dedalus.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(emplist);
			System.out.println("Serilized to file dedalus.txt");
			oos.close();
			fos.close();
			}
			catch(FileNotFoundException fnf)
			{
				System.out.println("No file");
			}
	}
	public void deserilalize() throws IOException{
		try{
			
			
			FileInputStream fis = new FileInputStream("dedalus.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			List<Employee> elist = (List<Employee>)ois.readObject();
			System.out.println("DeSerilized from file dedalus.txt");
			System.out.println(elist);		
			ois.close();
			fis.close();
			}
			catch(FileNotFoundException fnf)
			{
				System.out.println("No file");
			}
			catch(ClassNotFoundException cnf)
			{
				System.out.println("No Emp class");
		}
		finally {
			System.out.println("Deserialized");
		}
	}

	@Override
	public void sortByEid() {
		Collections.sort(empList);
		System.out.println("After sorting by EID");
		System.out.println(empList);
		
	}

	@Override
	public void sortByEname() {
		Collections.sort(empList, Employee.NameComparator);
		System.out.println(empList);
		
	}
	
	
}
