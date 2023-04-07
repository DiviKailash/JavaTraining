package com.dal;

import java.io.Serializable;
import java.util.Comparator;

//pojo - plain old java object
public class Employee implements Serializable ,Comparable<Employee>{

	public Employee(int no, String name) {

		this.eid =no;
		this.ename = name;
	}

	public Employee() {

	}

	int eid = 1;
	String ename = "divya";

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + "]";
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return this.eid - o.eid;
	}
	public static Comparator<Employee> NameComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {
			
			return e1.getEname().compareTo(e2.getEname());
		}
	
	
	};

}
