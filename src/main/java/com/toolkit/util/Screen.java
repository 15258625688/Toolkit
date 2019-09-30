package com.toolkit.util;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Screen {

	/**
	 * 获取当前屏幕的分辨率
	 * 
	 * @return
	 */
	public static int[] getScreenSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int[] arr = { (int) screenSize.getWidth(), (int) screenSize.getHeight() };
		return arr;
	}
}
