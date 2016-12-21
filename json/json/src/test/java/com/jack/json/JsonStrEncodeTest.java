package com.jack.json;

import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;

import com.jack.json.service.JsonStrEncode;

public class JsonStrEncodeTest {
	@Test
	public void test(){
		String json = "{\"userName\":\"曾锡金213*&、|、\\//839274psaodk阿斯顿（…………￥……￥%……￥……\"}";
		String encodeStr;
		try {
			encodeStr = JsonStrEncode.EncodeBase64(json);
			System.out.println(encodeStr);
			String decodeStr = JsonStrEncode.DecodeBase64(encodeStr);
			System.out.println(decodeStr);
			Assert.assertTrue(json.equals(decodeStr));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
