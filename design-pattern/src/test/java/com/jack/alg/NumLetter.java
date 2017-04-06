package com.jack.alg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumLetter {

	public static void main(String[] args) {
		NumLetter num = new NumLetter();
		char[] array = {'1','A','2','B','4','6','C','1'};
		num.sortLetterNum(array);
		System.out.println(array);
		
		char[] array2 = {'N','A','2','B','4','6','C','9'};
		num.sortLetterNum(array2);
		System.out.println(array2);
	}
	
	public boolean isNum(char ch){
		String val = String.valueOf(ch);
		Pattern p = Pattern.compile("(\\d+)");
		Matcher m = p.matcher(val);
		return m.matches();
	}
	
	public void mergeNumLetter(char[] array){
		int len = array.length;
		
		char letterTemp;
		int numIndex = 0;
		int letterIndex = 0;
		boolean firstNum = true;
		
		for(int i=0;i<len;i++){
			if(isNum(array[i]) == true){
				if(firstNum == false){
					firstNum = true;
					numIndex = i;
				}
			}else{
				letterTemp = array[i];
				letterIndex = i;
				
				firstNum = false;
				
				if(letterIndex > numIndex){
					for(int j = letterIndex; j>numIndex;j--){
						array[j] = array[j-1];
					}
					array[numIndex] = letterTemp;
				}
				numIndex = numIndex + 1;
			}
		}
	}
	
	public void sortLetterNum(char[] array){
		
		int numStartIndex = 0;
		int currentLetterIndex = 0;
		boolean isFirstNum = false;
		
		int len = array.length;
		char temp = array[len -1];
		
		for(int i=0;i<len;i++){
			if(isNum(array[i]) == true){
				if(isFirstNum == false){
					//numStartIndex = i;
					isFirstNum = false;
				}
			}else{
				currentLetterIndex = i;
				temp = array[i];
				
				for(int j=currentLetterIndex; j > numStartIndex; j--){
					array[j] = array[j-1];
				}
				array[numStartIndex] = temp;
				numStartIndex = numStartIndex + 1;
			}
		}
		
	}
	

}
