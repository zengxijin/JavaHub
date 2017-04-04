package com.mule.spring;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBean {

	public static void main(String[] args) {
		System.out.println(IdNOToAge("320623199305150021"));
	}
	
    public static int IdNOToAge(String idCard){
        if (idCard.length() == 18) {
            String birthYear = idCard.substring(6, 10);
            SimpleDateFormat df = new SimpleDateFormat("yyyy");
            String year = df.format(new Date());
            return Integer.parseInt(year) - Integer.parseInt(birthYear);
        }else{
            return 0;
        }
    }


}
