package com.extra;
public class MyOuter
{
	static int x =7;
	static abstract class MyInner
	{
		int i = 1;
		public void InnerMethod()
		{
			int localv=2;
			System.out.println("x == " + x);
		}
	}
	
	class child extends MyOuter.MyInner{
		public void InnerMethod()
		{
			System.out.println("MyOuter.MyInner" );
		}
	}
	
	public void OuterMethod()
	{
//		System.out.println("From outer method = " + x);
//		MyInner inn = new MyInner();
//		inn.InnerMethod();
	}
	public static void main(String[] a)
	{
	MyOuter mo = new MyOuter();
	
	//MyInner inn = new MyInner(); //invalid
	//inn.InnerMethod();
	//<outerclassname>.<innerclassname> objname = <outerclass instancename>.new <innerclassname>();
	MyOuter.child mi = mo.new child(); //instantiate inner class
	
	mi.InnerMethod();
//	mo.OuterMethod();
	//mi.OuterMethod();  illegal
	//mo.InnerMethod();   illegal 
		
	}

}

// Check whether the inner class can be abstract
// can it be inherited?
// scope of instance variable within the inner class 
// scope of local variable within the inner class







