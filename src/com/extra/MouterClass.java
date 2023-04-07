package com.extra;

public class MouterClass
{
	int x =10;
	public void OuterMethod()
	{
		int j=90;
		 abstract class MinnerClass
		{
			public void minnerMethod()
			{
			System.out.println("Hello ..." + x + j);
			}
		}
		 
		 class childMinner extends MinnerClass{
			 public void minnerMethod()
				{
				System.out.println("inherited by child");
				}
		 }
//		MinnerClass mic = new MinnerClass();
		 childMinner ch = new childMinner();
		 ch.minnerMethod();
//		mic.minnerMethod();		
		
	}	
	public static void main(String[] a)
	{
		MouterClass moc = new MouterClass();
		moc.OuterMethod();		
	
		//MinnerClass mic = new MinnerClass();
		//mic.minnerMethod();
	}
}


//Create instance and local variable inside the inner class and access
// Can the method local inner class be abstract?













