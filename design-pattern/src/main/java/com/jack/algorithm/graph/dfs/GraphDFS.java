package com.jack.algorithm.graph.dfs;

import java.util.Stack;

import com.jack.algorithm.graph.COLOR;
import com.jack.algorithm.graph.Graph;
import com.jack.algorithm.graph.Vertex;
/**
 * Depth First Search
 * @ClassName: GraphDFS
 * @author:  Jack Zeng 
 * @CreateDate: [2016年9月5日 下午5:20:46]   
 * @UpdateUser: Jack Zeng 
 * @UpdateDate: [2016年9月5日 下午5:20:46]   
 * @UpdateRemark: [TODO()]
 * @Description:  [TODO()]
 * @version: [V1.0]
 */

public class GraphDFS {
	/**recursive traversal*/
	public static void recursiveDFS(Graph graph) {
		Vertex start = graph.startNode;
		if (start.isVisited() == false) {
			System.out.println(start.toString());
			start.setVisited(true);
		}

		int index = graph.vertexes.indexOf(start);
		int[] adjacency = graph.adjacentMatrix[index];
		for (int i = 0; i < adjacency.length; i++) {
			Vertex nextV = graph.vertexes.get(i);
			if (nextV.isVisited() == false) {
				graph.startNode = nextV;
				recursiveDFS(graph);
			}
		}
	}
	
	/**use stack to traversal*/
	public static void DFS(Graph graph) {
		Vertex start = graph.startNode;
		Stack<Vertex> stack = new Stack<Vertex>();
		
		stack.push(start);
		start.setColor(COLOR.GRAY);
		
		while(!stack.isEmpty()){
			Vertex v = stack.pop();
			v.setVisited(true);
			v.setColor(COLOR.BLACK);
			
			System.out.println(v.toString());
			
			int index = graph.vertexes.indexOf(v);
			int[] adjacency = graph.adjacentMatrix[index];
			for(int i=0;i<adjacency.length;i++){
				Vertex tmp = graph.vertexes.get(i);
				if(adjacency[i] != 0 && tmp.getColor() == COLOR.WHITE){
					tmp.setColor(COLOR.GRAY);
					stack.push(tmp);
					break;
				}
			}
			
			System.out.println(stack);
		}
		
	}

}
