package com.toolkit.entity;

import java.util.regex.Pattern;

public class Address {

	private int ip;

	private int port;

	public int getIp() {
		return ip;
	}

	public String getIpToString() {
		return intToIP(ip);
	}

	public void setIp(int ip) {
		this.ip = ip;
	}

	public void setIp(String ip) throws Exception {
		this.ip = IpToInt(ip);
	}

	public int getPort() {
		return port;
	}

	public void setPort(short port) {
		this.port = port;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ip;
		result = prime * result + port;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (ip != other.ip)
			return false;
		if (port != other.port)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [ip=" + intToIP(ip) + ", port=" + port + "]";
	}

	public Address(String ip, int port) throws Exception {
		this(IpToInt(ip), port);
	}

	public Address(int ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	private final static String ipReg = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";

	private static boolean isIP(String ip) throws Exception {
		if (ip == null || ip.isEmpty())
			throw new Exception("ip isempty");
		Pattern ipPattern = Pattern.compile(ipReg);
		return ipPattern.matcher(ip.trim()).matches();
	}

	/**
	 * 将IP地址转为int
	 * 
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	public static int IpToInt(String ip) throws Exception {
		if (!isIP(ip))
			throw new Exception("this " + ip + " not is IP");
		String[] arr = ip.trim().split("[.]");
		int[] arr1 = new int[arr.length];
		for (int n = 0; n < arr.length; n++)
			arr1[n] = Integer.parseInt(arr[n]);
		return arr1[0] << 24 | arr1[1] << 16 | arr1[2] << 8 | arr1[3];
	}

	/**
	 * int转为IP地址
	 * 
	 * @param ip
	 * @return
	 */
	public static String intToIP(int ip) {
		return (ip >> 24) + "." + (ip >> 16 & 0xff) + "." + (ip >> 8 & 0xff) + "." + (ip & 0xff);
	}
}
