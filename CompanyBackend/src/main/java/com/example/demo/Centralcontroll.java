package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.function.EntityResponse;

@ControllerAdvice
public class Centralcontroll {
	@ExceptionHandler(CustomException.class)
//	public EntityResponse<Object> myMessage(CustomException e){
//		return new ResponseEntity
//	}
	public ResponseEntity<Object> myMessage(CustomException e){
		return new ResponseEntity<> (e.getMessage(),HttpStatus.ACCEPTED);
	}
}
