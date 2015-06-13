package com.barclays.graph.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.barclays.model.TerminalEdge;
import com.barclays.model.TerminalVertex;

public class DijkstraAlgorithm {

	private final List<TerminalVertex> nodes;
	private final List<TerminalEdge> edges;
	private Set<TerminalVertex> settledNodes;
	private Set<TerminalVertex> unSettledNodes;
	private Map<TerminalVertex, TerminalVertex> predecessors;
	private Map<TerminalVertex, Integer> distance;

	public DijkstraAlgorithm(ConveyorGraph graph) {
		// create a copy of the array so that we can operate on this array
		this.nodes = new ArrayList<TerminalVertex>(graph.getVertexs());
		this.edges = new ArrayList<TerminalEdge>(graph.getEdges());
	}

	public void execute(TerminalVertex source) {
		settledNodes = new HashSet<TerminalVertex>();
		unSettledNodes = new HashSet<TerminalVertex>();
		distance = new HashMap<TerminalVertex, Integer>();
		predecessors = new HashMap<TerminalVertex, TerminalVertex>();
		distance.put(source, 0);
		unSettledNodes.add(source);
		while (unSettledNodes.size() > 0) {
			TerminalVertex node = getMinimum(unSettledNodes);
			settledNodes.add(node);
			unSettledNodes.remove(node);
			findMinimalDistances(node);
		}
	}

	private void findMinimalDistances(TerminalVertex node) {
		List<TerminalVertex> adjacentNodes = getNeighbors(node);
		for (TerminalVertex target : adjacentNodes) {
			if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
				distance.put(target, getShortestDistance(node) + getDistance(node, target));
				predecessors.put(target, node);
				unSettledNodes.add(target);
			}
		}

	}

	public int getDistance(TerminalVertex node, TerminalVertex target) {
		for (TerminalEdge edge : edges) {
			if (edge.getSource().equals(node) && edge.getDestination().equals(target)) {
				return edge.getWeight();
			}
		}
		throw new RuntimeException("Should not happen");
	}

	private List<TerminalVertex> getNeighbors(TerminalVertex node) {
		List<TerminalVertex> neighbors = new ArrayList<TerminalVertex>();
		for (TerminalEdge edge : edges) {
			if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
				neighbors.add(edge.getDestination());
			}
		}
		return neighbors;
	}

	private TerminalVertex getMinimum(Set<TerminalVertex> TerminalVertexes) {
		TerminalVertex minimum = null;
		for (TerminalVertex vertex : TerminalVertexes) {
			if (minimum == null) {
				minimum = vertex;
			} else {
				if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
					minimum = vertex;
				}
			}
		}
		return minimum;
	}

	private boolean isSettled(TerminalVertex TerminalVertex) {
		return settledNodes.contains(TerminalVertex);
	}

	private int getShortestDistance(TerminalVertex destination) {
		Integer d = distance.get(destination);
		if (d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}

	/*
	 * This method returns the path from the source to the selected target and
	 * NULL if no path exists
	 */
	public LinkedList<TerminalVertex> getPath(TerminalVertex target) {
		LinkedList<TerminalVertex> path = new LinkedList<TerminalVertex>();
		TerminalVertex step = target;
		// check if a path exists
		if (predecessors.get(step) == null) {
			return null;
		}
		path.add(step);
		while (predecessors.get(step) != null) {
			step = predecessors.get(step);
			path.add(step);
		}
		// Put it into the correct order
		Collections.reverse(path);
		return path;
	}

	public int getDistance(TerminalVertex target) {
		return distance.get(target);
	}
}
