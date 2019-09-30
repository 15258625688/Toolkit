package com.toolkit.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Util {

	public final static String DEFAULT_CHARSET = "UTF-8";

	/**
	 * Base64解码
	 * 
	 * @param str
	 * @return
	 */
	public static String decode(String str) {
		return decode(str, DEFAULT_CHARSET);
	}

	public static String decode(String str, String charsetName) {
		byte[] bytes = Base64.getDecoder().decode(str);
		String data = null;
		try {
			data = new String(bytes, charsetName);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * Base64编码
	 * 
	 * @param str
	 * @return
	 */
	public static String encoder(String str) {
		return encoder(str, DEFAULT_CHARSET);
	}

	public static String encoder(String str, String charsetName) {
		String data = null;
		try {
			byte[] bytes = Base64.getEncoder().encode(str.getBytes(charsetName));
			data = new String(bytes, charsetName);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return data;
	}

}
