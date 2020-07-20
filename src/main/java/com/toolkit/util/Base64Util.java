package com.toolkit.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Util {

    public final static String DEFAULT_CHARSET = "UTF-8";

    // 对应格式文件base64字符串前缀
    public final static String DOC = "data:application/msword;base64,";
    public final static String DOCX = "data:application/vnd.openxmlformats-officedocument.wordprocessingml.document;base64,";
    public final static String XLS = "data:application/vnd.ms-excel;base64,";
    public final static String XLSX = "data:application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;base64,";
    public final static String PDF = "data:application/pdf;base64,";
    public final static String PPT = "data:application/vnd.ms-powerpoint;base64,";
    public final static String PPTX = "data:application/vnd.openxmlformats-officedocument.presentationml.presentation;base64,";
    public final static String TXT = "data:text/plain;base64,";
    public final static String PNG = "data:image/png;base64,";
    public final static String JPG = "data:image/jpeg;base64,";
    public final static String GIF = "data:image/gif;base64,";
    public final static String SVG = "data:image/svg+xml;base64,";
    public final static String ICO = "data:image/x-icon;base64,";
    public final static String BMP = "data:image/bmp;base64,";

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

    public static String inputStreamToBase64(InputStream is) throws IOException {
	ByteArrayOutputStream os = new ByteArrayOutputStream();
	byte[] bs = new byte[8 * 1024];
	int n = 0;
	while ((n = is.read(bs)) != -1)
	    os.write(bs, 0, n);
	return new String(org.apache.commons.codec.binary.Base64.encodeBase64(os.toByteArray()));
    }

    public static InputStream base64ToInputStream(String base64Str) throws IOException {
	if (base64Str == null)
	    return null;
	byte[] data = org.apache.commons.codec.binary.Base64.decodeBase64(base64Str.getBytes());
	ByteArrayInputStream is = new ByteArrayInputStream(data);
	return is;
    }

}
