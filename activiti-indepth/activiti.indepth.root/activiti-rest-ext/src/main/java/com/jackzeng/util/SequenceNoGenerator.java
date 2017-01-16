package com.jackzeng.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class SequenceNoGenerator {
	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
	private final static Random rand = new Random();
	public static String getSequenceNo() {
		return sdf.format(new Date()) + String.valueOf(System.nanoTime() + rand.nextInt(999)).substring(8);
	}
}
