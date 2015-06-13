package com.barclays.graph.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.barclays.bag.service.BagService;
import com.barclays.departure.service.DepartureService;
import com.barclays.exception.BagExeption;
import com.barclays.exception.DepartureExeption;
import com.barclays.model.Bag;
import com.barclays.model.TerminalEdge;
import com.barclays.model.TerminalVertex;

public class ConveyorServiceImpl implements ConveyorService {
	private Map<String, TerminalEdge> terminals = new LinkedHashMap<String, TerminalEdge>();
	private final BagService bagService;
	private final DepartureService departureService;
	public static final String OUTPUT_FORMAT = "%s %s : %d";

	public ConveyorServiceImpl(BagService bagService, DepartureService departureService) {
		this.bagService = bagService;
		this.departureService = departureService;
	}

	@Override
	public void addTerminal(String id, TerminalVertex source, TerminalVertex destination, int weight) {
		TerminalEdge edge = new TerminalEdge(id, source, destination, weight);
		String rev = "Rev" + id;
		TerminalEdge edgeRev = new TerminalEdge(id, destination, source, weight);
		terminals.put(id, edge);
		terminals.put(rev, edgeRev);

	}

	@Override
	public List<TerminalVertex> getPath(ConveyorGraph graph, TerminalVertex source, TerminalVertex destination) {
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
		dijkstra.execute(source);
		List<TerminalVertex> path = dijkstra.getPath(destination);
		System.out.println("Distance:" + dijkstra.getDistance(destination));
		return path;
	}

	@Override
	public List<TerminalEdge> getTerminals() {
		return new ArrayList<TerminalEdge>(terminals.values());
	}

	@Override
	public String optimizedRouteForBag(ConveyorGraph graph, Bag bag) throws BagExeption {
		try {
			TerminalVertex source = bag.getSource();
			TerminalVertex destination = departureService.findDestinationByBag(bag);
			DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
			dijkstra.execute(source);
			List<TerminalVertex> path = dijkstra.getPath(destination);
			return String.format(OUTPUT_FORMAT, bag.getBagNumber(), path, dijkstra.getDistance(destination));
		} catch (DepartureExeption e) {
			throw new BagExeption(e);
		}
	}
}
