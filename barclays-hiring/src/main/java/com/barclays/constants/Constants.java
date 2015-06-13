package com.barclays.constants;

import com.barclays.model.TerminalVertex;

public interface Constants {

	String BAGGAGE_CLAIM = "BaggageClaim";
	String ARRIVAL = "ARRIVAL";
	TerminalVertex ARRIVAL_TERMINAL = new TerminalVertex("BaggageClaim", "BaggageClaim");

	String DATE_FORMAT = "hh:mm";
}
