package com.example.handler;

public class InvalidUrl extends RuntimeException{
	 private String message;
	public InvalidUrl(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
        this.message = msg;
	}
}
