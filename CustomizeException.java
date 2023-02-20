package com.ajith;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomizeException {
@ExceptionHandler
public ResponseEntity<ApiResponse> exceptionHandler(BadRequestException e){

	ApiResponse apiResponse=new ApiResponse();
	apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
	apiResponse.setError(e.getErrors());
	return ResponseEntity.status(400).body(apiResponse);
}
@ExceptionHandler
public ResponseEntity<String> exceptionHandler(DetailsNotFound e){
HttpHeaders header=new HttpHeaders();
header.add("details", "not found");
String message=" Record Not found ,please check your input details ";
	return new ResponseEntity<String>(message,header, HttpStatus.BAD_REQUEST);
}
}
