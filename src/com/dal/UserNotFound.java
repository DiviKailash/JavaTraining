package com.dal;
import java.io.*;

public class UserNotFound extends Exception {
	public UserNotFound(String user){
		System.out.println("Exception "+user+" not found");
	}

}
