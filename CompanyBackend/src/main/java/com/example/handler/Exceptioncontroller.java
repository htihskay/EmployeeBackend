package com.example.handler;

import org.hibernate.internal.util.MarkerObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Exceptioncontroller {
	
	@ExceptionHandler
	public ResponseEntity<MarkerObject> handleNoDataException(Employeehandler ex){
		MarkerObject eob=new MarkerObject();
		
	}
}
