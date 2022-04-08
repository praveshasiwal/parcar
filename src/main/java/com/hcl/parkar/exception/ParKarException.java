package com.hcl.parkar.exception;

public class ParKarException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ParKarException() {
		super();
	}

	public ParKarException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ParKarException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParKarException(String message) {
		super(message);
	}

	public ParKarException(Throwable cause) {
		super(cause);
	}
	
	

}
