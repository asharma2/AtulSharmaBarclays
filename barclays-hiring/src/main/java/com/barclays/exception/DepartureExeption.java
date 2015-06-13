package com.barclays.exception;

public class DepartureExeption extends Exception {

	private static final long serialVersionUID = -2661296829231880319L;

	public DepartureExeption() {
	}

	public DepartureExeption(String error) {
		super(error);
	}

	public DepartureExeption(Throwable cause) {
		super(cause);
	}

	public DepartureExeption(String error, Throwable cause) {
		super(error, cause);
	}

}
