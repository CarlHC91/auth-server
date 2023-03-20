package org.raspberry.auth.service.exceptions;

public class ServiceErrorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServiceErrorException() {
		super();
	}

	public ServiceErrorException(String message) {
		super(message);
	}

	public ServiceErrorException(Throwable cause) {
		super(cause);
	}

	public ServiceErrorException(String message, Throwable cause) {
		super(message, cause);
	}

}