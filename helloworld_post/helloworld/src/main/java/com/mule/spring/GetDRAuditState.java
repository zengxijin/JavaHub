package com.mule.spring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class GetDRAuditState {
	
	public static void main(String[] args){
		
		//Date dd = new Date(1480297650000L);
		//System.out.println(dd);
		
		GetDRAuditState dr = new GetDRAuditState();
		try {
			dr.getAudit(dr.readFileByLines("D:\\loanNo.txt"),
					"Bearer Yzk0ZmMzY2U2OGQ5NGJlM2FmNjkxNWE2M2Q4ZGRmODc");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void getAudit(List<String> loanNoList,String token) throws InterruptedException{
		if(loanNoList == null || loanNoList.isEmpty()){
			System.out.println("warn:empty list");
			return;
		}
			
		try {
			for (String loanNo : loanNoList) {
				HttpResponse<String> response = Unirest
						.get("https://loanapp.dianrong.com/v2/quark/apps/status?extId=" + loanNo)
						.header("authorization", token)
						.header("cache-control", "no-cache").asString();

				System.out.println(loanNo + ":" + response.getBody());
				
				Thread.sleep(300);
			}
		} catch (UnirestException e) {
			e.printStackTrace();
		}
	}
	
	public  List<String> readFileByLines(String fileName) {
		File file = new File(fileName);
		BufferedReader reader = null;
		List<String> list = new ArrayList<String>();
		
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				list.add(tempString.trim());
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return list;
	}
}
