package com.extra;

public class MyOuterClass {

	int x =7;
	class MyInner
	{
		public void InnerMethod()
		{
			System.out.println("x == " + x);
		}
	}
	public void OuterMethod()
	{
		System.out.println("From outer method = " + x);
		MyInner inn = new MyInner();
		inn.InnerMethod();
	}
	public static void main(String[] a)
	{
	MyOuterClass mo = new MyOuterClass();
	//MyInner inn = new MyInner(); //invalid
	//inn.InnerMethod();
	//<outerclassname>.<innerclassname> objname = <outerclass instancename>.new <innerclassname>();
	MyOuterClass.MyInner mi = mo.new MyInner(); //instantiate inner class
	mi.InnerMethod();
	mo.OuterMethod();
	//mi.OuterMethod();  illegal
	//mo.InnerMethod();   illegal 
		
	}

}



