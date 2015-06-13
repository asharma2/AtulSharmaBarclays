package com.barclays.graph.service;

import java.util.List;

import com.barclays.model.TerminalEdge;
import com.barclays.model.TerminalVertex;

public class ConveyorGraph {

	private final List<TerminalVertex> vertexs;
	private final List<TerminalEdge> edges;

	public ConveyorGraph(List<TerminalVertex> vertexs, List<TerminalEdge> edges) {
		this.vertexs = vertexs;
		this.edges = edges;
	}

	public List<TerminalVertex> getVertexs() {
		return vertexs;
	}

	public List<TerminalEdge> getEdges() {
		return edges;
	}
	
	

}
