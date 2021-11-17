package com.btc.app.exception;

public class InvalidPhoneNoException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public InvalidPhoneNoException()
	{
		
	}
	public InvalidPhoneNoException(String message)
	{
		super(message);
	}
}