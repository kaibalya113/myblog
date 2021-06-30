package com.myblog.main.custom.exception;

public class DataNotFoundException extends RuntimeException{
	
	public DataNotFoundException(String message) {
		super(message);
	}
}
