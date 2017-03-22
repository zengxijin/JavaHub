package org.jackzeng.kie.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;

public class BRMCBase64 {
	public static String EncodeBase64(String text) throws UnsupportedEncodingException {
		return new String(Base64.encodeBase64(text.getBytes("UTF-8")), Charset.forName("UTF-8"));
	}

	public static String DecodeBase64(String text) throws UnsupportedEncodingException {
		return new String(Base64.decodeBase64(text.getBytes("UTF-8")), Charset.forName("UTF-8"));
	}
}
