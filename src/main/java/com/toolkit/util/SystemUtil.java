package com.toolkit.util;

import java.io.IOException;
import java.util.Scanner;

public class SystemUtil {
	/**
	 * 获取机器码
	 * 
	 * @return
	 */
	@SuppressWarnings({ "resource", "unused" })
	public static String getSerial() {
		try {
			Process process = Runtime.getRuntime().exec("C:\\Windows\\System32\\wbem\\wmic cpu get ProcessorId");
			process.getOutputStream().close();
			Scanner sc = new Scanner(process.getInputStream());
			String property = sc.next();
			String serial = sc.next();
			return serial;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
