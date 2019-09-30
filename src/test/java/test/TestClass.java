package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.toolkit.util.Base64Util;
import com.toolkit.util.ByteUtil;
import com.toolkit.util.SystemUtil;

public class TestClass {
	private static String s = "7E 32 30 30 31 44 30 30 30 46 37 32 38 30 31 30 31 44 39 44 33 34 44 41 41 34 30 30 30 30 30 39 38 34 31 30 30 30 30 41 30 34 30 30 30 30 30 37 30 34 31 30 30 30 30 34 30 34 30 30 30 30 30 36 30 34 31 30 30 30 30 31 30 34 31 30 30 30 30 39 30 34 31 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 31 37 30 38 35 33 34 36 33 33 37 33 43 39 34 30 35 43 38 46 30 41 33 45 31 45 34 35 46 34 34 30 38 35 36 42 46 34 34 30 35 43 38 46 30 41 33 45 43 33 31 34 30 39 34 36 33 43 39 34 30 33 34 36 43 44 46 42 43 32 34 35 37 30 33 44 30 41 33 45 39 39 39 39 30 39 33 45 37 30 33 44 30 41 33 45 34 38 45 31 30 41 33 45 37 31 33 44 30 41 33 45 34 38 45 31 30 41 33 45 35 43 38 46 30 41 33 45 39 41 39 39 30 39 33 45 37 31 33 44 30 41 33 45 32 39 35 43 38 37 33 45 31 34 41 45 38 37 33 45 30 41 44 37 38 37 33 45 35 43 38 46 30 41 33 45 38 35 45 42 30 39 33 45 37 31 33 44 30 41 33 45 37 31 33 44 30 41 33 45 39 41 39 39 30 39 33 45 37 30 33 44 30 41 33 45 37 31 33 44 30 41 33 45 39 41 39 39 30 39 33 45 37 31 33 44 30 41 33 45 44 30 32 31 35 33 34 36 38 46 38 32 37 36 34 31 37 33 31 33 42 37 34 36 33 44 30 41 43 46 33 45 30 30 30 30 44 30 33 45 33 33 33 33 43 46 33 45 41 34 37 30 34 42 33 46 32 39 35 43 43 46 33 45 33 44 30 41 43 46 33 45 33 44 30 41 43 46 33 45 31 37 30 38 35 33 34 36 33 33 37 33 43 39 34 30 31 34 41 45 30 37 33 45 43 44 32 31 35 33 34 36 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 45 30 34 30 30 30 32 30 46 42 34 35 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 32 38 30 30 39 38 34 39 45 30 30 30 37 30 34 39 32 30 30 31 31 30 34 39 30 30 30 30 30 30 30 30 32 43 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 31 30 30 30 30 39 37 46 39 0D";

	@Test
	public void test1() throws Exception {
		s = s.trim().replace(" ", "");
		byte[] bs = ByteUtil.hexToBytes(s);
//		System.out.println(Arrays.toString(bs));
		ByteArrayInputStream bis = new ByteArrayInputStream(bs);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		// 头
		byte[] b = new byte[1];
		bis.read(b);
		String head = ByteUtil.bytesToHexString(b);
		System.out.println("head:" + head);
		bos.write(b);
		// 版本
		b = new byte[2];
		bis.read(b);
		String version = ByteUtil.ASCIIBytesToString(b);
		System.out.println("version:" + version);
		bos.write(b);
		// 地址
		b = new byte[2];
		bis.read(b);
		String address = ByteUtil.ASCIIBytesToString(b);
		System.out.println("address:" + address);
		bos.write(b);
		// cmd
		b = new byte[4];
		bis.read(b);
		String cmd = ByteUtil.ASCIIBytesToString(b);
		System.out.println("cmd:" + cmd);
		bos.write(b);
		byte[] lenth = { 0x00, 0x00 };
		bos.write(lenth);
		byte[] b1 = bos.toByteArray();
		System.out.println(Arrays.toString(b1));
		int sum = 0;
		for (int n = 1; n < b1.length; n++) {
			sum += b1[n];
		}
		System.out.println(sum);
		sum = ((~sum + 1) % 65536);
		System.out.println(sum);
		byte[] b11 = { (byte) (sum >> 4 & 0xff), (byte) (sum & 0xff) };
		String sum11 = ByteUtil.bytesToHexString(b11);
		System.out.println(sum11);
		System.out.println(sum);
	}

	@Test
	public void test2() throws IOException, Exception {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		bos.write(ByteUtil.hexToBytes("7E"));
		bos.write(ByteUtil.hexToBytes("3130"));
		bos.write(ByteUtil.hexToBytes("3138"));
		bos.write(ByteUtil.hexToBytes("36363435"));
		bos.write(ByteUtil.hexToBytes("45303032"));
		bos.write(ByteUtil.hexToBytes("0000"));
		byte[] b = bos.toByteArray();
		System.out.println(Arrays.toString(b));
		int sum = 0;
		for (int n = 1; n < b.length; n++) {
			sum += b[n];
		}
		System.out.println(sum);
		sum = ((~sum + 1) % 65536);
		System.out.println(sum);
		byte[] b11 = { (byte) (sum >> 4 & 0xff), (byte) (sum & 0xff) };
		String sum11 = ByteUtil.bytesToHexString(b11);
		System.out.println(sum11);
	}

	@Test
	public void test3() {
		String str = "20";
		byte[] bs = str.getBytes();
		System.out.println(Arrays.toString(bs));
		System.out.println(ByteUtil.bytesToHexString(bs));
	}

	@Test
	public void test4() {
		int a = 0;
		for (int n = 0; n < 100; n++)
			a = ++a;
		System.out.println(a);
	}

	@Test
	public void test5() {
		String code = "3000";
		while (code.endsWith("0")) {
			code = code.substring(0, code.length() - 1);
		}
		System.out.println(code);
	}

	@Test
	public void test6() {
		String s = SystemUtil.getSerial();
		System.out.println(s);
	}

	@Test
	public void test7() {
		String s = "eyJsb29wMXB3cmYiOiIwLjAwJDAuMDAmMC4wMCIsImN1ciI6IjAuMDAkMC4wMCYwLjAwIiwibWV0ZXJudW0iOiIyMDE5MDgyMSIsImxvb3Axdm9sIjoiMjUuNjAkMjUuNTUmMjguNzQiLCJkYXRhdHlwZSI6MywibG9vcDFjdXIiOiIwLjAwJDAuMDAmMC4wMCIsImxvb3AxaW5zcCI6IjAuMDAkMC4wMCYwLjAwIiwibWVzc2FnZWlkIjoiIiwiaW5zcSI6IjAuMDAkMC4wMCYwLjAwIiwibG9vcDFpbnNxIjoiMC4wMCQwLjAwJjAuMDAiLCJzaWduYWxsZXZlbCI6MjQsInRpbWUiOjE1Njg4NzUxMzAsImluc3AiOiIwLjAwJDAuMDAmMC4wMCJ9";
		System.out.println(s.length());
		System.out.println(Base64Util.decode(s));
	}

	@Test
	public void test8() {
		String s = "eyJsb29wMXB3cmYiOiIwLjAwJDAuMDAmMC4wMCIsImN1ciI6IjAuMDAkMC4wMCYwLjAwIiwibWV0ZXJudW0iOiIyMDE5MDgyMSIsImxvb3Axdm9sIjoiMjUuNjAkMjUuNTUmMjguNzQiLCJkYXRhdHlwZSI6MywibG9vcDFjdXIiOiIwLjAwJDAuMDAmMC4wMCIsImxvb3AxaW5zcCI6IjAuMDAkMC4wMCYwLjAwIiwibWVzc2FnZWlkIjoiIiwiaW5zcSI6IjAuMDAkMC4wMCYwLjAwIiwibG9vcDFpbnNxIjoiMC4wMCQwLjAwJjAuMDAiLCJzaWduYWxsZXZlbCI6MjQsInRpbWUiOjE1Njg4NzUxMzAsImluc3AiOiIwLjAwJDAuMDAmMC4wMCJ9eyJsb29wMXB3cmYiOiIwLjAwJDAuMDAmMC4wMCIsImN1ciI6IjAuMDAkMC4wMCYwLjAwIiwibWV0ZXJudW0iOiIyMDE5MDgyMSIsImxvb3Axdm9sIjoiMjUuNjAkMjUuNTUmMjguNzQiLCJkYXRhdHlwZSI6MywibG9vcDFjdXIiOiIwLjAwJDAuMDAmMC4wMCIsImxvb3AxaW5zcCI6IjAuMDAkMC4wMCYwLjAwIiwibWVzc2FnZWlkIjoiIiwiaW5zcSI6IjAuMDAkMC4wMCYwLjAwIiwibG9vcDFpbnNxIjoiMC4wMCQwLjAwJjAuMDAiLCJzaWduYWxsZXZlbCI6MjQsInRpbWUiOjE1Njg4NzUxMzAsImluc3AiOiIwLjAwJDAuMDAmMC4wMCJ9";
		System.out.println(s.length());
		System.out.println(Base64Util.decode(s));
	}

	@Test
	public void test9() {
		String json = "{\r\n" + "	\"messageid\": \"\",\r\n" + "	\"meternum\": \"20190821\",\r\n"
				+ "	\"datatype\": 3,\r\n" + "	\"signallevel\": 11,\r\n" + "	\"time\": 0,\r\n"
				+ "	\"cur\": \"000.000$000.000$000.000\",\r\n" + "	\"loop1vol\": \"216.8$000.0$000.0\",\r\n"
				+ "	\"insp\": \"00.0000$00.0000$00.0000$00.0000\",\r\n"
				+ "	\"insq\": \"00.0000$00.0000$00.0000$00.0000\",\r\n"
				+ "	\"loop1pwrf\": \"1.000$1.000$0.000$0.000\"\r\n" + "}";
		json = JSONObject.parse(json).toString();
		String str = Base64Util.encoder(json);
		System.out.println(str.length());
		System.out.println(str);
	}

	@Test
	public void test10() {
		String json = "{\r\n" + "	\"messageid\": \"c033284e3ab945e2bc0fce6890b09358\",\r\n"
				+ "	\"meternum\": \"5100401000000100000718\",\r\n" + "	\"iccid\": \"iccid\",\r\n"
				+ "	\"imei\": \"imei\",\r\n" + "	\"version\": \"version\",\r\n" + "	\"orgid\": \"100000\",\r\n"
				+ "	\"datatype\": 0,\r\n" + "	\"signallevel\": 11,\r\n" + "	\"interval\": 10,\r\n"
				+ "	\"metertype\": 301,\r\n" + "\"meterchannel\": 3,\r\n" + "	\"moduletype\": 0,\r\n"
				+ "	\"longitude\":\"34.123123\",\r\n" + "	\"latitude\": \"3.422\",\r\n"
				+ "	\"fullorgid\": \"100000,110000,111000\",\r\n" + "	\"siteid\": \"22222\"\r\n" + "}\r\n" + "";
		JSONObject jsonObject = JSONObject.parseObject(json);
		System.out.println(jsonObject);
	}
}
