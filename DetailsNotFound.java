package com.ajith;

public class DetailsNotFound extends RuntimeException{
 private String message;

public DetailsNotFound(String message) {
	super(message);
	this.message = message;
}
 public DetailsNotFound() {
	 
 }
}
