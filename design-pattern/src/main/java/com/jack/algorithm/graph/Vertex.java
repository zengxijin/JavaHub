package com.jack.algorithm.graph;

public class Vertex {
	
	private String  info      = null;
	private COLOR   color     = COLOR.WHITE;
	private boolean isVisited = false;
	
	public void initStates(){
		this.color = COLOR.WHITE;
		this.isVisited = false;
	}
	
	public Vertex(String info){
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public COLOR getColor() {
		return color;
	}

	public void setColor(COLOR color) {
		this.color = color;
	}
	
	public String toString(){
		return info;
	}

}
