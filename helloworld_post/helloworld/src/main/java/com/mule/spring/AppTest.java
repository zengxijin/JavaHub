package com.mule.spring;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AppTest {

	public static void main(String[] args) {

		long startTime = System.nanoTime();
		System.out.println(getSequenceNumber2());
		System.out.println(System.nanoTime());
		System.out.println(System.nanoTime());

		// String ss =
		// "0;D504_01;D506_16;D506_25;D504_03;D504_08;IDENTITY;HZ_NAME;HZ_D401_01;D504_18;xb;D301_09;D504_28;D504_06;D101_02;ITEM_NAME;D504_09;DIAGNOSIS_NAME;BCLX;D504_11;D504_12;D504_13;D506_03;BEGINPAY;BZBL;BZHJ;BZHJ_DX;GRFD;D404_17;ZFYHJ;BCFYHJ;";
		// String[] aa = ss.split(";");
		// int i = 0;
		// for(String s:aa){
		// System.out.println("\"" + s + "\":" + "\"" + i + "\",");
		// i++;
		// }
	}

	public static String getSequenceNumber() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String str = sdf.format(d);
		String haomiao = String.valueOf(System.nanoTime());
		str = str + haomiao.substring(haomiao.length() - 6, haomiao.length());
		return str;
	}

	public static String getSequenceNumber2() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		return sdf.format(new Date()) + String.valueOf(System.nanoTime()).substring(8);
	}

}
