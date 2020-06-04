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

	public static String byteToHexString(byte b) {
		final char[] cs = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		return cs[b >> 4 & 0xf] + "" + cs[b & 0xf];
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

	/**
	 * 根据数据信息长度计算L.TH
	 * 
	 * @param length
	 * @return
	 */
	public static byte[] getL_TH(int length) {
		int lchkSum = 16 - (((length & 0xf) + (length >> 4) & 0xf + (length >> 8) & 0xf)) % 16;
		int l_th = length | (lchkSum << 12);
		return new byte[] { (byte) ((l_th & 0xff00) >> 8), (byte) (l_th & 0xff) };
	}

	/**
	 * 根据byte[]计算CHECKSUM
	 * 
	 * @param bs
	 * @return
	 */
	public static short getCheckSum(byte[] bs) {
		if (bs.length == 0)
			return 0;
		byte b = 0;
		for (byte b1 : bs)
			b += b1;
		return (short) (~(b % 65536) + 1);
	}
}
