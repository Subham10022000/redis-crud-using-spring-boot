package com.redis1.rediscache.customexception;

public class InvoiceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1669727356386017741L;
	
	public InvoiceNotFoundException(String message) {
	super(message);

	
	}
}
