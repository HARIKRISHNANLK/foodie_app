package com.btc.app.ui;

public class RestaurantNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RestaurantNotFoundException()
	{
		
	}
	
	public RestaurantNotFoundException(String msg)
	{
		super(msg);
	}

}