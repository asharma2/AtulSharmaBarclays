package com.barclays.model;

import java.util.Date;

public class Departure {

	private final String flightId;
	private final TerminalVertex flightGate;
	private final String destination;
	private final Date flightTime;

	public Departure(String flightId, TerminalVertex flightGate, String destination, Date flightTime) {
		this.flightId = flightId;
		this.flightGate = flightGate;
		this.destination = destination;
		this.flightTime = flightTime;
	}

	public String getFlightId() {
		return flightId;
	}

	public TerminalVertex getFlightGate() {
		return flightGate;
	}

	public String getDestination() {
		return destination;
	}

	public Date getFlightTime() {
		return new Date(flightTime.getTime());
	}

}
