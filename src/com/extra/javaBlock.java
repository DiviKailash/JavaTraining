package com.extra;
import static java.lang.Math.*;
public class javaBlock {

	
	static int num1;
	int num2;
	
	static
	{	
		System.out.println("From Static Block2");
		num1=99;
	}
	//First Static Block	
	static
	{	
		System.out.println("From Static Block1");
		num1=60;
	}
	//First Non-static Block
		{
			System.out.println("From Non-Static Block1");
			num2 =80;		
		}
	public static void main(String[] args) {
		        javaBlock jb = new javaBlock();
				System.out.println(num1);
				System.out.println(jb.num2);

				/*System.out.println(cos(0));		
				System.out.println(sin(90));
				System.out.println(sqrt(50));
				*/

	}

}
