package com.cg;

public class AddressBookDBException extends Exception{

	private static final long serialVersionUID = 1L;

	enum ExceptionType{
		CONNECTION_ERROR, INCORRECT_INFO
	}

	ExceptionType type;

	public AddressBookDBException(ExceptionType type, String message) {
		super(message);
		this.type = type;
	}
}