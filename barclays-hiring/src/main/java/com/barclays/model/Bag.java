package com.barclays.model;

public class Bag {

	private final String bagNumber;
	private final TerminalVertex source;
	private final String flightId;

	public Bag(String bagNumber, TerminalVertex source, String flightId) {
		this.bagNumber = bagNumber;
		this.source = source;
		this.flightId = flightId;
	}

	public String getBagNumber() {
		return bagNumber;
	}

	public TerminalVertex getSource() {
		return source;
	}

	public String getFlightId() {
		return flightId;
	}

}
