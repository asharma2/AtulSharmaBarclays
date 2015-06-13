package com.barclays.graph.service;

import java.util.List;

import com.barclays.exception.BagExeption;
import com.barclays.model.Bag;
import com.barclays.model.TerminalEdge;
import com.barclays.model.TerminalVertex;

public interface ConveyorService {

	public void addTerminal(String id, TerminalVertex source, TerminalVertex destination, int weight);

	public List<TerminalVertex> getPath(ConveyorGraph graph, TerminalVertex source, TerminalVertex destination);

	public List<TerminalEdge> getTerminals();

	public String optimizedRouteForBag(ConveyorGraph graph, Bag bag) throws BagExeption;
}
