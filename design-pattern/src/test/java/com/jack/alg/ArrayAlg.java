package com.jack.alg;

import java.util.Arrays;
import java.util.List;

public class ArrayAlg {
	
	public static void main(String[] args){
		Integer[] arrayList = {3,2,1,5,7,6,8,6};
		System.out.println(ArrayAlg.findMid(Arrays.asList(arrayList)));
		
		int[] intArray = {3,2,1,5,7,6,8,6};
		System.out.println(ArrayAlg.findMidInt(intArray));
		
	}
	
	//泛型的实现算法
	public static <T extends Comparable<? super T>> int findMid(List<T> list){
		System.out.println(list);
		
		int len = list.size();
		T max = list.get(0);
		T candidate = list.get(0);
		int index = 0;
		boolean isFound = true;
		
		for(int i=1; i < len; i++){
			if(isFound == true){
				if( candidate.compareTo(list.get(i)) > 0){
					isFound = false;
				}else{
					max = list.get(i);
				}
			}else{
				if(max.compareTo(list.get(i)) <= 0){
					max = list.get(i);
					candidate = list.get(i);
					isFound = true;
					index = i;
				}
			}
		}
		
		return isFound == true? index : -1;
		
	}
	
	//int数组实现方式
	public static int findMidInt(int [] src){
		int len = src.length;
		int max = src[0];
		int candidate = src[0];
		int index = 0;
		boolean isFound = true;
		
		for(int i=1; i < len; i++){
			if(isFound == true){
				if(candidate > src[i]){
					isFound = false;
				}else{
					max = src[i];
				}
			}else{
				if(src[i] >= max){
					candidate = src[i];
					max = src[i];
					index = i;
					
					isFound = true;
				}
			}
		}
		
		return isFound == true? index : -1;
	}
	
	
}
