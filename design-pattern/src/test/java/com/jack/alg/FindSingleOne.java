package com.jack.alg;

public class FindSingleOne {

	public static void main(String[] args) {
		int[] test = {1,2,3,1,2,2,1,4,4,4};
		System.out.println(singleNumber(test));
	}
	
	//Given an array of integers, every element appears three times except for one. Find that single one.
	//一组整数，除了一个只出现一次以外，其他每个整数都恰好出现三次，要寻找那个特殊的整数。
	public static int singleNumber(int[] A) {
	    int ones = 0, twos = 0;
	    for(int i = 0; i < A.length; i++){
	        ones = (ones ^ A[i]) & ~twos;
	        twos = (twos ^ A[i]) & ~ones;
	    }
	    return ones;
	}
	
	//一种算法是利用累加和对3取余

}
