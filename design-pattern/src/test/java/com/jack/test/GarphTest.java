package com.jack.test;

import com.jack.algorithm.graph.Graph;
import com.jack.algorithm.graph.bfs.GraphBFS;

public class GarphTest {

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.test();
		
		GraphBFS.bfs(graph);
	}

}
