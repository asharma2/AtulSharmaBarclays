package com.barclays.model;

public class TerminalEdge {

	private final String id;
	private final TerminalVertex source;
	private final TerminalVertex destination;
	private final int weight;

	public TerminalEdge(String id, TerminalVertex source, TerminalVertex destination, int weight) {
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	public String getId() {
		return id;
	}

	public TerminalVertex getSource() {
		return source;
	}

	public TerminalVertex getDestination() {
		return destination;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return String.format("%s  %s", source, destination);
	}
}
