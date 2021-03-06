package com.machengjie.clonenote.service;

public class UserNameException extends RuntimeException {
	private static final long serialVersionUID = -329001646812932369L;

	public UserNameException() {
	}

	public UserNameException(String message) {
		super(message);
	}

	public UserNameException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNameException(Throwable cause) {
		super(cause);
	}

	public UserNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
