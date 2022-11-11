package com.example.handler;

import org.hibernate.boot.InvalidMappingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


public class Employeehandler  extends RuntimeException{
//
//	@ExceptionHandler(value=NumberFormatException.class)
//	public String invalidUrl(Exception e) {
//		return e.getMessage();
//	}
	public Employeehandler(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}

}
