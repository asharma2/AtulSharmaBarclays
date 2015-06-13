package com.barclays.exception;

public class BagExeption extends Exception {

    private static final long serialVersionUID = -7866188883781097662L;

	public BagExeption() {
	}

	public BagExeption(String error) {
		super(error);
	}

	public BagExeption(Throwable cause) {
		super(cause);
	}

	public BagExeption(String error, Throwable cause) {
		super(error, cause);
	}

}
