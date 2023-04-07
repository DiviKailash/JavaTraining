package com.extra;

import java.io.*;

 class UserNotFoundExceptions extends Exception{
	public UserNotFoundExceptions(){
		System.out.println("Exception user not found");
		
	}
}


public class ApplicationSpecificException {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			String uname = null;
			String pwd = null;
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Enter Uname:");
			uname = br.readLine();
			System.out.println("Enter pwd:");
			pwd = br.readLine();
			
			if(uname.equals("divya")&& pwd.equals("divya")) {
				System.out.println("Welcome " + uname);
			}
			else {
				throw new UserNotFoundExceptions();
				
			}
		} catch (UserNotFoundExceptions  e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

	}

}
