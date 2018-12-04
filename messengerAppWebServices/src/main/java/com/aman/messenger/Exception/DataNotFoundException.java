package com.aman.messenger.Exception;

// We want run time exception thats wyy we extends the RunTimeException 
public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DataNotFoundException(String message) {
		super(message);
	}

}
