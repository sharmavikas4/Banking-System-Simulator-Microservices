package com.exceptions;

public class NoTransactionFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoTransactionFoundException(String message) {
		super(message);
	}
}
