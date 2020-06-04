package com.toolkit.entity.accesscontroller;

import java.io.Serializable;

/**
 * 门禁控制器报文
 * 
 * @author 张豪浩 zhanghaohao0820@gmail.com
 *
 */
public class AccessControllerMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 起始符
	protected byte SOI = 0x7e;
	// 版本
	protected byte[] VER = new byte[2];
	// 地址
	protected byte[] ADR = new byte[2];
	// 类码与地址组
	protected byte[] CID1 = new byte[2];
	// 类别
	protected byte[] CID2_RTN = new byte[2];
	// 参数长度校验
	protected byte[] L_TH = new byte[4];
	// 参数
	protected byte[] INFO = new byte[0];
	// 帧校验
	protected byte[] SUM = new byte[4];
	// 结束符
	protected byte EOI = 0x0d;

	public byte getSOI() {
		return SOI;
	}

	public void setSOI(byte sOI) {
		SOI = sOI;
	}

	public byte[] getVER() {
		return VER;
	}

	public void setVER(byte[] vER) {
		VER = vER;
	}

	public byte[] getADR() {
		return ADR;
	}

	public void setADR(byte[] aDR) {
		ADR = aDR;
	}

	public byte[] getCID1() {
		return CID1;
	}

	public void setCID1(byte[] cID1) {
		CID1 = cID1;
	}

	public byte[] getCID2_RTN() {
		return CID2_RTN;
	}

	public void setCID2_RTN(byte[] cID2_RTN) {
		CID2_RTN = cID2_RTN;
	}

	public byte[] getL_TH() {
		return L_TH;
	}

	public void setL_TH(byte[] l_TH) {
		L_TH = l_TH;
	}

	public byte[] getINFO() {
		return INFO;
	}

	public void setINFO(byte[] iNFO) {
		INFO = iNFO;
	}

	public byte[] getSUM() {
		return SUM;
	}

	public void setSUM(byte[] sUM) {
		SUM = sUM;
	}

	public byte getEOI() {
		return EOI;
	}

	public void setEOI(byte eOI) {
		EOI = eOI;
	}

	public byte[] getBytes() {
		byte[] bytes = new byte[1 + VER.length + ADR.length + CID1.length + CID2_RTN.length + L_TH.length + INFO.length
				+ SUM.length + 1];
		int n = 0;
		bytes[n] = SOI;
		n++;
		for (byte b : VER) {
			bytes[n] = b;
			n++;
		}
		for (byte b : ADR) {
			bytes[n] = b;
			n++;
		}
		for (byte b : CID1) {
			bytes[n] = b;
			n++;
		}
		for (byte b : CID2_RTN) {
			bytes[n] = b;
			n++;
		}
		for (byte b : L_TH) {
			bytes[n] = b;
			n++;
		}
		for (byte b : INFO) {
			bytes[n] = b;
			n++;
		}
		for (byte b : SUM) {
			bytes[n] = b;
			n++;
		}
		bytes[n] = EOI;
		return bytes;
	}
}
