package com.btc.app.exception;
public class InvalidRestaurantIdException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public InvalidRestaurantIdException() {
			
		}
		
		public InvalidRestaurantIdException(String message) {
			super(message);
		}
}
