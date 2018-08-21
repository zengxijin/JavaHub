package com.jack.test;

import com.jack.algorithm.graph.Graph;
import com.jack.algorithm.graph.bfs.GraphBFS;
import com.jack.algorithm.graph.dfs.GraphDFS;

public class GarphTest {

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.test();
		
		//GraphBFS.bfs(graph);
		GraphDFS.recursiveDFS(graph);
		//GraphDFS.DFS(graph);
	}

}
