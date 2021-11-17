package com.btc.app.exception;

public class InvalidRestaurantNameException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public InvalidRestaurantNameException()
	{
		
	}
	public InvalidRestaurantNameException(String message)
	{
		super(message);
	}

}
