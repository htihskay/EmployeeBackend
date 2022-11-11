package com.example.demo;

public class CustomException extends Exception {
	public CustomException(){
		super("Only Non-negative integer allowed for EmployeeID");
	}
}
