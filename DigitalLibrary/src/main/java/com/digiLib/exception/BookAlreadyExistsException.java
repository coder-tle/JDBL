package com.digiLib.exception;

public class BookAlreadyExistsException extends RuntimeException{
	private String message;
	public BookAlreadyExistsException() {
		
	}
	public BookAlreadyExistsException(String message) {
		super(message);
		this.message = message;
	}
}
