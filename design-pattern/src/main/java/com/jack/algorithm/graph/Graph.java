package com.jack.algorithm.graph;

import java.util.ArrayList;

public class Graph {
	
	public Vertex  startNode      = null;
	public int[][] adjacentMatrix = null;
	public ArrayList<Vertex> vertexes = new ArrayList<Vertex>();
	
	public void setAjacent(Vertex v1, Vertex v2,int weight){
		adjacentMatrix[vertexes.indexOf(v1)][vertexes.indexOf(v2)] = weight;
		adjacentMatrix[vertexes.indexOf(v2)][vertexes.indexOf(v1)] = weight;
	}
	
	public void printStatus(){
		for(Vertex v:vertexes){
			System.out.println(v.toString() + " " + v.isVisited() + " " + v.getColor());
		}
	}
	
	public void test(){
		Vertex A = new Vertex("A");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
		Vertex B = new Vertex("B");
		Vertex C = new Vertex("C");
		Vertex D = new Vertex("D");
		Vertex E = new Vertex("E");
		
		vertexes.add(A);
		vertexes.add(B);
		vertexes.add(C);
		vertexes.add(D);
		vertexes.add(E);

		int matrixSize = vertexes.size();
		
		adjacentMatrix = new int[matrixSize][matrixSize];
		for(int i=0;i<matrixSize;i++){
			for(int j=0;j<matrixSize;j++){
				adjacentMatrix[i][j] = 0;
			}
		}
		
		setAjacent(A, B, 1);
		setAjacent(A, D, 1);
		
		setAjacent(B, C, 1);
		setAjacent(B, E, 1);
		
		setAjacent(C, B, 1);
		setAjacent(C, D, 1);
		
		setAjacent(D, A, 1);
		setAjacent(D, C, 1);
		setAjacent(D, E, 1);
		
		setAjacent(E, D, 1);
		setAjacent(E, B, 1);
		
		startNode = A;
	}
	
	public void printAjacentMatrix(){
		int matrixSize = vertexes.size();
		for(int i=0;i<matrixSize;i++){
			for(int j=0;j<matrixSize;j++){
				System.out.print(adjacentMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
