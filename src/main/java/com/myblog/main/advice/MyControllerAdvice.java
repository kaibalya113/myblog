package com.myblog.main.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.myblog.main.custom.exception.DataNotFoundException;

@ControllerAdvice
public class MyControllerAdvice {
	
	// In here we can handle custom exceptioin as well as global exceptions
	// first we use global exception
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<String> userNotFoundException(UsernameNotFoundException usernameNotFoundException){
		return new ResponseEntity<String>("No user has found. Try again", HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(InternalAuthenticationServiceException.class)
	public ResponseEntity<String> interAuthException(InternalAuthenticationServiceException usernameNotFoundException){
		return new ResponseEntity<String>(usernameNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	// using custom exception
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<String> DataNotFoundException(DataNotFoundException dataNotFoundException, WebRequest request){
		
		return new ResponseEntity<String>(dataNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
	}
}
