package com.example.demo1.ExceptionEntity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ApiResponse> UserNotFoundExceptionHandler(UserNotFoundException ex) {
		//ApiResponse api=new ApiResponse();
		ApiResponse apires = new ApiResponse();	
		
		
		apires.setMessage(ex.getMessage()); 
		apires.setStatus(false);
		return new ResponseEntity<ApiResponse>(apires,HttpStatus.BAD_REQUEST);
	}
 
}
