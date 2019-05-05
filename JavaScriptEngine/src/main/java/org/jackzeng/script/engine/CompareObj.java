package org.jackzeng.script.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareObj implements Comparable<CompareObj> {
	private String name;
	private int age;
	
	public CompareObj(String name,int age){
		this.name = name;
		this.age  = age;
	}
	
	public String toString(){
		return "[name=" + this.name + ",age=" + this.age + "]";
	}

	public int compareTo(CompareObj o) {
		if(this == o) //self object
			return 0;
		
		CompareObj obj = o;
		
		if(this.age == obj.age){
			return 0;
		}
		
		if(this.age > obj.age){
			return 1;
		}
		
		if(this.age < obj.age){
			return -1;
		}
		
		return 0;
	}
	
	public static void main(String args[]){
		List<CompareObj> list = new ArrayList<CompareObj>();
		list.add(new CompareObj("A",10));
		list.add(new CompareObj("D",13));
		list.add(new CompareObj("B",12));
		list.add(new CompareObj("C",11));
		
		Collections.sort(list);
		
		System.out.println(list);
		
		Collections.sort(list,new Comparator<Object>(){
			public int compare(Object o1, Object o2) {
				CompareObj o11 = (CompareObj)o1;
				CompareObj o22 = (CompareObj)o2;
				
				if(o11.name != null){
					return o11.name.compareTo(o22.name);
				}
				
				if(o11.name == null){
					if(o22.name == null){
						return 0;
					}else if(o22.name != null){
						return -1;
					}
				}
					
				return 0;
			}
		});
		
		System.out.println(list);
		
		CompareObj a = new CompareObj("A",10);
		
		System.out.println(a.compareTo(a));
	}

}
