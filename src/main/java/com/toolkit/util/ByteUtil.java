package com.toolkit.util;

import java.util.regex.Pattern;

public class ByteUtil {
	/**
	 * 字节码转十六进制
	 * 
	 * @param bytes
	 * @return
	 */
	public static String bytesToHexString(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		final char[] cs = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		for (byte b : bytes)
			sb.append(cs[b >> 4 & 0xf]).append(cs[b & 0xf]);
		return sb.toString();
	}

	/**
	 * 十六进制转字节码
	 * 
	 * @param hex
	 * @return
	 * @throws Exception
	 */
	public static byte[] hexToBytes(String hex) throws Exception {
		if (hex == null || hex.isEmpty())
			throw new Exception("param hex isempty");
		if (hex.length() % 2 != 0)
			throw new Exception("param hex length error");
		if (!Pattern.compile("^([0-9A-F])+$").matcher(hex.trim()).matches())
			throw new Exception("param hex error");
		byte[] bytes = new byte[hex.length() / 2];
		final String s = "0123456789ABCDEF";
		for (int n = 0; n < bytes.length; n++)
			bytes[n] = (byte) ((s.indexOf(hex.charAt(2 * n)) << 4) | (s.indexOf(hex.charAt(2 * n + 1))));
		return bytes;
	}

	public static String ASCIIBytesToString(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes)
			sb.append((char) b);
		return sb.toString();
	}

	public static String strToASCIIString(String str) {
		if (str == null)
			return "";
		StringBuilder sb = new StringBuilder();
		for (int n = 0; n < str.length(); n++) {
			int ascii = str.charAt(n);
			sb.append(ascii);
		}
		return sb.toString();
	}
}
