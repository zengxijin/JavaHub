package com.jack.algorithm.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.jack.algorithm.graph.COLOR;
import com.jack.algorithm.graph.Graph;
import com.jack.algorithm.graph.Vertex;

public class GraphBFS {
	/** Breadth First Search */
	public static void bfs(Graph graph) {
		Vertex start = graph.startNode;
		Queue<Vertex> queue = new LinkedList<Vertex>();

		queue.add(start);
		start.setColor(COLOR.GRAY);

		while (!queue.isEmpty()) {
			Vertex v = queue.poll();
			
			System.out.print(v.toString());

			int index = graph.vertexes.indexOf(v);
			int ajdacent[] = graph.adjacentMatrix[index];
			for (int i = 0; i < ajdacent.length; i++) {
				if (ajdacent[i] != 0) {
					Vertex tmp = graph.vertexes.get(i);
					if (tmp.isVisited() == false && tmp.getColor() == COLOR.WHITE) {
						queue.add(tmp);
						tmp.setColor(COLOR.GRAY);
					}
				}
			}

			v.setColor(COLOR.BLACK);
			v.setVisited(true);

			System.out.println(" " + queue);
		}
		
		rollBackStatus(graph);
	}
	
	private static void rollBackStatus(Graph graph){
		for(int i=0;i<graph.vertexes.size();i++){
			graph.vertexes.get(i).initStates();
		}
	}
}
