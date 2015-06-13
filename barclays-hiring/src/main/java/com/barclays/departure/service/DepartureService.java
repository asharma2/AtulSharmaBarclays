package com.barclays.departure.service;

import com.barclays.exception.DepartureExeption;
import com.barclays.model.Bag;
import com.barclays.model.Departure;
import com.barclays.model.TerminalVertex;

public interface DepartureService {

	public void saveDeparture(Departure departure) throws DepartureExeption;

	public TerminalVertex findDestinationByFlightId(String flightId) throws DepartureExeption;

	public TerminalVertex findDestinationByBag(Bag bag) throws DepartureExeption;
}
