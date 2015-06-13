package com.barclays.services;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.barclays.bag.service.BagService;
import com.barclays.bag.service.BagServiceImpl;
import com.barclays.departure.service.DepartureService;
import com.barclays.departure.service.DepartureServiceImpl;
import com.barclays.graph.service.ConveyorGraph;
import com.barclays.graph.service.ConveyorService;
import com.barclays.graph.service.ConveyorServiceImpl;
import com.barclays.model.Bag;
import com.barclays.model.Departure;
import com.barclays.model.TerminalVertex;
import com.barclays.utils.Utilities;

public class TestConveyorSystem {

	private BagService bagService;
	private DepartureService departureService;
	private ConveyorService conveyorService;
	private List<TerminalVertex> nodes;

	@Before
	public void before() {
		System.out.println("--------------------------------------");
		departureService = DepartureServiceImpl.getInstance();
		bagService = BagServiceImpl.getInstance();
		conveyorService = new ConveyorServiceImpl(bagService, departureService);
		nodes = new LinkedList<TerminalVertex>();
	}

	@After
	public void after() {
		System.out.println("--------------------------------------");
		departureService = null;
		bagService = null;
		conveyorService = null;
	}

	@Test
	public void testServiceLifeCycle() throws Exception {
		createTestData();
		System.out.println("=============================================");
		//
		ConveyorGraph graph = new ConveyorGraph(nodes, conveyorService.getTerminals());
		Bag bag = bagService.findByBagNumber("00001");
		String result = conveyorService.optimizedRouteForBag(graph, bag);
		System.out.println(result);
		System.out.println("*********************************************");
		bag = bagService.findByBagNumber("00002");
		result = conveyorService.optimizedRouteForBag(graph, bag);
		System.out.println(result);
		System.out.println("*********************************************");
		bag = bagService.findByBagNumber("00003");
		result = conveyorService.optimizedRouteForBag(graph, bag);
		System.out.println(result);
		System.out.println("*********************************************");
		bag = bagService.findByBagNumber("00004");
		result = conveyorService.optimizedRouteForBag(graph, bag);
		System.out.println(result);
		System.out.println("*********************************************");
		bag = bagService.findByBagNumber("00005");
		result = conveyorService.optimizedRouteForBag(graph, bag);
		System.out.println(result);

	}

	private void createTestData() throws Exception {
		TerminalVertex a1 = new TerminalVertex("A1", "A1");
		nodes.add(a1);
		TerminalVertex a2 = new TerminalVertex("A2", "A2");
		nodes.add(a2);
		TerminalVertex a3 = new TerminalVertex("A3", "A3");
		nodes.add(a3);
		TerminalVertex a4 = new TerminalVertex("A4", "A4");
		nodes.add(a4);
		TerminalVertex a5 = new TerminalVertex("A5", "A5");
		nodes.add(a5);
		TerminalVertex a6 = new TerminalVertex("A6", "A6");
		nodes.add(a6);
		TerminalVertex a7 = new TerminalVertex("A7", "A7");
		nodes.add(a7);
		TerminalVertex a8 = new TerminalVertex("A8", "A8");
		nodes.add(a8);
		TerminalVertex a9 = new TerminalVertex("A9", "A9");
		nodes.add(a9);
		TerminalVertex a10 = new TerminalVertex("A10", "A10");
		nodes.add(a10);
		/*
		 * Adding the departure to cache
		 */
		Departure departure1 = new Departure("UA10", a1, "MIA", Utilities.getTime("08:00"));
		departureService.saveDeparture(departure1);
		Departure departure2 = new Departure("UA11", a1, "LAX", Utilities.getTime("09:00"));
		departureService.saveDeparture(departure2);
		Departure departure3 = new Departure("UA12", a1, "JFK", Utilities.getTime("09:45"));
		departureService.saveDeparture(departure3);
		Departure departure4 = new Departure("UA13", a2, "JFK", Utilities.getTime("08:30"));
		departureService.saveDeparture(departure4);
		Departure departure5 = new Departure("UA14", a2, "JFK", Utilities.getTime("09:45"));
		departureService.saveDeparture(departure5);
		Departure departure6 = new Departure("UA15", a2, "JFK", Utilities.getTime("10:00"));
		departureService.saveDeparture(departure6);
		Departure departure7 = new Departure("UA16", a3, "JFK", Utilities.getTime("09:00"));
		departureService.saveDeparture(departure7);
		Departure departure8 = new Departure("UA17", a4, "MHT", Utilities.getTime("09:15"));
		departureService.saveDeparture(departure8);
		Departure departure9 = new Departure("UA18", a5, "LAX", Utilities.getTime("10:15"));
		departureService.saveDeparture(departure9);
		// Connectivity
		TerminalVertex concourseA = new TerminalVertex("Concourse_A_Ticketing", "Concourse");
		nodes.add(concourseA);
		TerminalVertex baggageClaim = new TerminalVertex("BaggageClaim", "BaggageClaim");
		nodes.add(baggageClaim);
		// Adding bag to cache
		Bag bag1 = new Bag("00001", concourseA, "UA12");
		bagService.saveBag(bag1);
		Bag bag2 = new Bag("00002", a5, "UA17");
		bagService.saveBag(bag2);
		Bag bag3 = new Bag("00003", a2, "UA10");
		bagService.saveBag(bag3);
		Bag bag4 = new Bag("00004", a8, "UA18");
		bagService.saveBag(bag4);
		Bag bag5 = new Bag("00005", a7, "ARRIVAL");
		bagService.saveBag(bag5);
		//
		conveyorService.addTerminal("CAT-A5", concourseA, a5, 5);
		conveyorService.addTerminal("A5-BC", a5, baggageClaim, 5);
		conveyorService.addTerminal("A5-A10", a5, a10, 4);
		conveyorService.addTerminal("A5-A1", a5, a1, 6);
		conveyorService.addTerminal("A1-A2", a1, a2, 1);
		conveyorService.addTerminal("A2-A3", a2, a3, 1);
		conveyorService.addTerminal("A3-A4", a3, a4, 1);
		conveyorService.addTerminal("A10-A9", a10, a9, 1);
		conveyorService.addTerminal("A9-A8", a9, a8, 1);
		conveyorService.addTerminal("A8-A7", a8, a7, 1);
		conveyorService.addTerminal("A7-A6", a7, a6, 1);

	}
}
