package com.extra;


  class Emp{
	 int empid = 123;
	String empname = "Arun";
	 public String getDetails() {
		return empid+ "---"+ empname;
	}
	public Emp() {
		super(); // to invoke base class constructor 
		//it should be the first statement in the constructor
		
	}
	public Emp(int empid) {
		super();
		this.empid = empid;
	}
	
	
}

class Manager extends Emp{

	public Manager() {
		this("hello"); // to invoke base class constructor 
		//it should be the first statement in the constructor
		
	}
	
	
	 public Manager(String dept) {
		
		this.dept = dept;
	}


	String dept= "IT";
	public String getDetails() {
		return super.getDetails() + "--"+ dept; // super keyword calls the Base class method
	}
	
}
public class InMainClass {
	
	
	public static void main(String[] args) {
		Emp emp = new Emp();
		System.out.println("From Base");
		System.out.println(emp.getDetails());
		Manager m = new Manager();
		System.out.println("From Child");
		System.out.println(m.getDetails());
		
	}

}
