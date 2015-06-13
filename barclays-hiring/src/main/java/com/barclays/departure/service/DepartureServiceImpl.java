package com.barclays.departure.service;

import java.util.LinkedHashMap;
import java.util.Map;

import com.barclays.constants.Constants;
import com.barclays.exception.DepartureExeption;
import com.barclays.model.Bag;
import com.barclays.model.Departure;
import com.barclays.model.TerminalVertex;

public class DepartureServiceImpl implements DepartureService {

	private static final DepartureServiceImpl INSTANCE = new DepartureServiceImpl();
	private Map<String, Departure> departures = new LinkedHashMap<String, Departure>();

	public static DepartureService getInstance() {
		return INSTANCE;
	}

	@Override
	public TerminalVertex findDestinationByFlightId(String flightId) throws DepartureExeption {
		Departure departure = departures.get(flightId);
		if (departure == null) {
			throw new DepartureExeption("No destination found for given flightId: " + flightId);
		}
		return departure.getFlightGate();
	}

	@Override
	public void saveDeparture(Departure departure) throws DepartureExeption {
		if (departure == null) {
			throw new DepartureExeption("Departure instance cannot be null");
		}
		departures.put(departure.getFlightId(), departure);
	}

	@Override
	public TerminalVertex findDestinationByBag(Bag bag) throws DepartureExeption {
		if (bag == null) {
			throw new DepartureExeption("Bag instance cannot be null");
		}

		if (bag.getFlightId().equals(Constants.ARRIVAL))
			return Constants.ARRIVAL_TERMINAL;

		return findDestinationByFlightId(bag.getFlightId());
	}

}
