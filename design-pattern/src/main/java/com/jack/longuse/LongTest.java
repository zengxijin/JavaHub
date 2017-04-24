package com.jack.longuse;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LongTest {

	public static void main(String[] args) {
		Long a = new Long(0);
		Long b = new Long(10);
		
		a += b;
		
		System.out.println(Math.pow(10, 2));
		
		Map<String,Long> map = new HashMap<String,Long>();
	    Iterator it = map.keySet().iterator();
	    
	}

}
