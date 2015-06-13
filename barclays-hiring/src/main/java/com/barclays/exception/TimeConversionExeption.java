package com.barclays.exception;

public class TimeConversionExeption extends Exception {

	private static final long serialVersionUID = -5735386361459561117L;

	public TimeConversionExeption() {
	}

	public TimeConversionExeption(String error) {
		super(error);
	}

	public TimeConversionExeption(Throwable cause) {
		super(cause);
	}

	public TimeConversionExeption(String error, Throwable cause) {
		super(error, cause);
	}

}
