package com.toolkit.util;

import java.util.Base64;
import java.util.Date;
import java.util.UUID;

import com.alibaba.fastjson.JSONObject;

/**
 * token工具
 * 
 * @author 张豪浩 zhanghaohao0820@gmail.com
 *
 */
public class TokenUtil {

	public static String createToken() throws Exception {
		return createToken("");
	}

	public static String createToken(Object obj) throws Exception {
		if (obj == null)
			obj = "";
		String json = JSONObject.toJSONString(obj).trim();
		int length = 0;
		if (obj instanceof String)// 字符串转json后长度会多2
			length = ((String) obj).length();
		else
			length = json.length();
		String content = "{date:" + new Date().getTime() + ",length:" + length + ",data:" + json + ",uuid:\""
				+ UUID.randomUUID().toString().replace("-", "") + "\"}";
		byte[] bs = content.getBytes("UTF-8");
		byte[] vs = getValidation(bs);
		int index = 0;
		byte[] bytes = new byte[bs.length + vs.length];
		for (byte b : bs) {
			bytes[index] = (byte) (b + index);
			index++;
		}
		for (byte b : vs) {
			bytes[index] = (byte) (b + index);
			index++;
		}
		String hex = ByteUtil.bytesToHexString(flip(bytes));
		return new String(Base64.getEncoder().encode(hex.getBytes("UTF-8")), "UTF-8");
	}

	public static Object decodeToken(String token) {
		Object obj = null;
		try {
			String hex = new String(Base64.getDecoder().decode(token), "UTF-8");
			byte[] bytes = flip(ByteUtil.hexToBytes(hex));
			for (int index = 0, n = 0; index < bytes.length; index++, n++)
				bytes[index] = (byte) (bytes[index] - n);
			byte[] bs = new byte[bytes.length - 4];
			System.arraycopy(bytes, 0, bs, 0, bytes.length - 4);
			byte[] vs = new byte[4];
			System.arraycopy(bytes, bytes.length - 4, vs, 0, 4);
			if (ByteUtil.bytesToHexString(getValidation(bs)).equals(ByteUtil.bytesToHexString(vs))) {
				String content = new String(bs, "UTF-8");
				JSONObject json = JSONObject.parseObject(content);
				if (json != null) {
					Integer length = json.getInteger("length");
					Object data = json.get("data");
					if (length != null && data != null && length == data.toString().length())
						obj = data;
				}
			}
		} catch (Exception e) {
			return null;
		}
		return obj;
	}

	public static byte[] getBytes(int n) {
		return new byte[] { (byte) (n >> 24 & 0xff), (byte) (n >> 16 & 0xff), (byte) (n >> 8 & 0xff),
				(byte) (n & 0xff) };
	}

	public static byte[] getBytes_flip(int n) {
		return new byte[] { (byte) (n & 0xff), (byte) (n >> 8 & 0xff), (byte) (n >> 16 & 0xff),
				(byte) (n >> 24 & 0xff) };
	}

	public static int getInt(byte[] bytes) {
		int n = 0;
		int index = 0;
		for (int i = bytes.length - 1; i >= 0; i--) {
			n = (bytes[i] << index | n);
			index += 8;
		}
		return n;
	}

	public static int getInt_flip(byte[] bytes) {
		int n = 0;
		int index = 0;
		for (byte b : bytes) {
			n = (b << index | n);
			index += 8;
		}
		return n;
	}

	public static byte[] getValidation(byte[] bytes) {
		int v = bytes.length;
		for (byte b : bytes)
			v ^= (b & 1) | (v << 1);
		return getBytes_flip(v);
	}

	public static byte[] flip(byte[] bytes) {
		byte[] bs = new byte[bytes.length];
		for (int index = bytes.length - 1, n = 0; index >= 0; index--, n++)
			bs[n] = bytes[index];
		return bs;
	}
}
