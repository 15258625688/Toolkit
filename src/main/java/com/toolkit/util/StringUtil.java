package com.toolkit.util;

public class StringUtil {

	/**
	 * 是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null || str.isEmpty() || str.equals("undefined"))
			return true;
		return false;
	}

	/**
	 * 字符串反转
	 * 
	 * @param str
	 * @return
	 */
	public static String reverse(String str) {
		if (str == null)
			return null;
		return new StringBuilder(str).reverse().toString();
	}
}
