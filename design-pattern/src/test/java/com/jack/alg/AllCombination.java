package com.jack.alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllCombination {

	public static void main(String[] args) {
		AllCombination a = new AllCombination();
		String ss = "";
		
		String[] N ={"1","2","3","4","5","6","7","8"}; 
		int[] abc = {1,2,3,4,5,6,7,8};
		
		for(int i=1;i <= abc.length;i++){
			int[] cpoyOf = Arrays.copyOf(abc, i);
			permute(cpoyOf,0);
		}
		
		
	}
	
	public static void permute(int[] array,int start){    
	    if(start==array.length){  // 输出  
	            System.out.println(Arrays.toString(array));  
	        }  
	    else  
	    for(int i=start; i<array.length; ++i){  
	        swap(array,start,i);  //  交换元素  
	        permute(array,start+1);  //交换后，再进行全排列算法  
	        swap(array,start,i);  //还原成原来的数组，便于下一次的全排列  
	        }  
	}  
	  
	private static void swap(int[] array,int s,int i){  
	    int t=array[s];  
	    array[s]=array[i];  
	    array[i]=t;  
	}  

}
