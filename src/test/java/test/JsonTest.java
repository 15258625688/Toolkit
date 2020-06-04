package test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Base64.Decoder;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.ctc.wstx.util.StringUtil;

public class JsonTest {
    String s1 = "{\"loop1pwrf\":\"0.99$0.99$0.94\",\"cur\":\"10.56$8.80$0.94\",\"meternum\":\"12191213000940\",\"loop1vol\":\"222.20$222.70$225.30\",\"datatype\":3,\"loop1cur\":\"10.56$8.80$0.94\",\"loop1insp\":\"2.25$1.77$0.08\",\"messageid\":\"\",\"insq\":\"80.30$80.19$80.04\",\"loop1insq\":\"80.30$80.19$80.04\",\"signallevel\":31,\"time\":1586589830000,\"insp\":\"2.25$1.77$0.08\"}{\"loop1kwh\":882.55,\"kwh\":882.55,\"messageid\":\"\",\"time\":158658";
    String s2 = "9830000,\"frozen\":0,\"signallevel\":31,\"meternum\":\"12191213000634\",\"datatype\":2}{\"loop1kwh\":691.5,\"kwh\":691.5,\"messageid\":\"\",\"time\":1586588400000,\"frozen\":1,\"signallevel\":31,\"meternum\":\"12191213000634\",\"datatype\":2}{\"loop1kwh\":691.5,\"kwh\":691.5,\"messageid\":\"\",\"time\":1586588400000,\"frozen\":1,\"signallevel\":31,\"meternum\":\"12191213000634\",\"datatype\":2}{\"meternum\":\"12191213000634\",\"timestamp\":1586589822000,\"messageid\":\"\",\"datatype\":4}{\"moduletype\":1,\"meterchannel\":1,\"meternum\":\"12191213000634\",\"orgid\":\"0107432\",\"siteid\":\"\",\"iccid\":\"89860447111880448777\",\"fullorgid\":\"\",\"datatype\":0,\"signallevel\":31,\"longitude\":\"\",\"messageid\":\"\",\"metertype\":301,\"interval\":60,\"latitude\":\"\",\"imei\":\"866714040160680\",\"version\":\"2.2.8\"}{\r\n"
	    + "	\"messageid\": \"32a06baa7aeb467bbd86296c8d0b2540\",\r\n"
	    + "	\"meternum\": \"5100401000000100000718\",\r\n" + "	\"datatype\": 1,\r\n"
	    + "	\"signallevel\": 11,\r\n" + "	\"warns\": [{\r\n" + "		\"warntype\": 0,\r\n"
	    + "		\"times\": 2,\r\n" + "		\"phasetype\": \"A\",\r\n" + "		\"keeptime\": 600,\r\n"
	    + "		\"lastoccurtime\": 1548224574,\r\n" + "		\"laststoptime\": 0,\r\n"
	    + "		\"current\": 0.0\r\n" + "	}]\r\n" + "}\r\n" + "";

    @Test
    public void test() {
	JSONObject jsonObject = JSONObject.parseObject(s1 + s2);
	System.out.println(jsonObject);
    }

    int index = 0;

    @Test
    public void test1() {
	StringBuilder sb = new StringBuilder();
	sb.append(
		"{\"loop1pwrf\":\"0.65$0.00$0.00\",\"cur\":\"1.37$0.00$0.00\",\"meternum\":\"12191213000054\",\"loop1vol\":\"235.40$0.00$0.00\",\"datatype\":3,\"messageid\":\"\",\"insq\":\"0.00$0.00$0.00\",\"signallevel\":23,\"time\":1586823972000,\"insp\":\"0.21$0.00$0.00\"}{\"loop1kwh\":113.94,\"kwh\":113.94,\"messageid\":\"\",\"time\":1586823972000,\"frozen\":0,\"signallevel\":23,\"meternum\":\"12191213000054\",\"datatype\":2}\r\n"
			+ "");
//	System.out.println("start:" + sb);
	System.out.println(sb.length());
	if (s1.startsWith("{")) {
	    for (int n = 0; n < sb.length(); n++) {
		if (sb.length() > 0)
		    if (sb.length() > 100000 || sb.charAt(0) != '{') {
			sb.setLength(0);
			return;
		    }
		char c = sb.charAt(n);
		if (c == '{') {
		    index++;
		}
		if (c == '}') {
		    index--;
		    if (index == 0) {
			String json = sb.substring(0, n + 1);
			sb.replace(0, n + 1, "");
			try {
			    System.out.println(json);
			} catch (Exception e) {
			}
			n = -1;
		    }
		}
	    }
	}
//	System.out.println("end:" + sb);
    }

    @Test
    public void test2() throws UnsupportedEncodingException {
	byte[] bs = { 112, 105, 110, 103 };
	System.out.println(new String(bs, "utf-8"));
    }

    @Test
    public void test3() throws Exception {
//	String msg = "eyJtZXNzYWdlaWQiOiIiLCJ3YXJucyI6W3sicGhhc2V0eXBlIjoiIiwiY3VycmVudCI6MCwidGltZXMiOjAsImtlZXB0aW1lIjo2MDAsImxhc3RvY2N1cnRpbWUiOjE1ODY3NTk5MDIwMDAsImxhc3RzdG9wdGltZSI6MH1dLCJzaWduYWxsZXZlbCI6MjAsIm1ldGVybnVtIjoiMTIxOTEyMTMwMDA2NjAiLCJkYXRhdHlwZSI6MX0=2eyJtZXNzYWdlaWQiOiIiLCJ3YXJucyI6W3sicGhhc2V0eXBlIjoiIiwiY3VycmVudCI6MCwidGltZXMiOjAsImtlZXB0aW1lIjo2MDAsImxhc3RvY2N1cnRpbWUiOjE1ODY3NTk5MDIwMDAsImxhc3RzdG9wdGltZSI6MH1dLCJzaWduYWxsZXZlbCI6MjAsIm1ldGVybnVtIjoiMTIxOTEyMTMwMDA2NjAiLCJkYXRhdHlwZSI6MX0=2eyJtZXNzYWdlaWQiOiIiLCJ3YXJucyI6W3sicGhhc2V0eXBlIjoiIiwiY3VycmVudCI6MCwidGltZXMiOjAsImtlZXB0aW1lIjo2MDAsImxhc3RvY2N1cnRpbWUiOjE1ODY3NTk5MDIwMDAsImxhc3RzdG9wdGltZSI6MH1dLCJzaWduYWxsZXZlbCI6MjAsIm1ldGVybnVtIjoiMTIxOTEyMTMwMDA2NjAiLCJkYXRhdHlwZSI6MX0=2eyJtZXNzYWdlaWQiOiIiLCJ3YXJucyI6W3sicGhhc2V0eXBlIjoiIiwiY3VycmVudCI6MCwidGltZXMiOjAsImtlZXB0aW1lIjo2MDAsImxhc3RvY2N1cnRpbWUiOjE1ODY3NTk5MDIwMDAsImxhc3RzdG9wdGltZSI6MH1dLCJzaWduYWxsZXZlbCI6MjAsIm1ldGVybnVtIjoiMTIxOTEyMTMwMDA2NjAiLCJkYXRhdHlwZSI6MX0=2eyJtZXNzYWdlaWQiOiIiLCJ3YXJu";
//	String s = new String(new BASE64Decoder().decodeBuffer(msg), "UTF-8").trim();
//	System.out.println(s);
    }

    @Test
    public void test4() throws Exception {
	String msg = "NjI3LjMzLCJtZXNzYWdlaWQiOiIiLCJ0aW1lIjoxNTg2ODQxOTc5MDAwLCJmcm96ZW4iOjAsInNpZ25hbGxldmVsIjoyOSwibWV0ZXJudW0iOiIxMjE5MTIxMzAwMDU2MiIsImRhdGF0eXBlIjoyfQ==eyJsb29wMWt3aCI6MTYyNi40NSwia3doIjoxNjI2LjQ1LCJtZXNzYWdlaWQiOiIiLCJ0aW1lIjoxNTg2ODQwNDAwMDAwLCJmcm96ZW4iOjEsInNpZ25hbGxldmVsIjoyOSwibWV0ZXJudW0iOiIxMjE5MTIxMzAwMDU2MiIsImRhdGF0eXBlIjoyfQ==eyJsb29wMWt3aCI6MTYyNi40NSwia3doIjoxNjI2LjQ1LCJtZXNzYWdlaWQiOiIiLCJ0aW1lIjoxNTg2ODQwNDAwMDAwLCJmcm96ZW4iOjEsInNpZ25hbGxldmVsIjoyOSwibWV0ZXJudW0iOiIxMjE5MTIxMzAwMDU2MiIsImRhdGF0eXBlIjoyfQ==4eyJtZXRlcm51bSI6IjEyMTkxMjEzMDAwNTYyIiwidGltZXN0YW1wIjoxNTg2ODQxOTY4MDAwLCJtZXNzYWdlaWQiOiIiLCJkYXRhdHlwZSI6NH0=3eyJtb2R1bGV0eXBlIjoxLCJtZXRlcmNoYW5uZWwiOjEsIm1ldGVybnVtIjoiMTIxOTEyMTMwMDA1NjIiLCJvcmdpZCI6IjAxMDc0MzIiLCJzaXRlaWQiOiIiLCJpY2NpZCI6Ijg5ODYwNDQ3MTExODgwNDQ4MjQ5IiwiZnVsbG9yZ2lkIjoiIiwiZGF0YXR5cGUiOjAsInNpZ25hbGxldmVsIjoyOSwibG9uZ2l0dWRlIjoiIiwibWVzc2FnZWlkIjoiIiwibWV0ZXJ0eXBlIjozMDEsImludGVydmFsIjo2MCwibGF0aXR1ZGUiOiIiLCJpbWVpIjoiODY2NzE0MDQwMTAzODk2IiwidmVyc2lvbiI6IjIuMi44In0=";
	System.out.println(msg.length());
	msg = msg.replace("ping", "");
	Base64.Decoder b64 = Base64.getDecoder();
	String s = new String(b64.decode(msg), "UTF-8").trim();
	System.out.println(s);
    }

    @Test
    public void test5() throws Exception {
//	String msg = "NjI3LjMzLCJtZXNzYWdlaWQiOiIiLCJ0aW1lIjoxNTg2ODQxOTc5MDAwLCJmcm96ZW4iOjAsInNpZ25hbGxldmVsIjoyOSwibWV0ZXJudW0iOiIxMjE5MTIxMzAwMDU2MiIsImRhdGF0eXBlIjoyfQ==eyJsb29wMWt3aCI6MTYyNi40NSwia3doIjoxNjI2LjQ1LCJtZXNzYWdlaWQiOiIiLCJ0aW1lIjoxNTg2ODQwNDAwMDAwLCJmcm96ZW4iOjEsInNpZ25hbGxldmVsIjoyOSwibWV0ZXJudW0iOiIxMjE5MTIxMzAwMDU2MiIsImRhdGF0eXBlIjoyfQ==eyJsb29wMWt3aCI6MTYyNi40NSwia3doIjoxNjI2LjQ1LCJtZXNzYWdlaWQiOiIiLCJ0aW1lIjoxNTg2ODQwNDAwMDAwLCJmcm96ZW4iOjEsInNpZ25hbGxldmVsIjoyOSwibWV0ZXJudW0iOiIxMjE5MTIxMzAwMDU2MiIsImRhdGF0eXBlIjoyfQ==4eyJtZXRlcm51bSI6IjEyMTkxMjEzMDAwNTYyIiwidGltZXN0YW1wIjoxNTg2ODQxOTY4MDAwLCJtZXNzYWdlaWQiOiIiLCJkYXRhdHlwZSI6NH0=3eyJtb2R1bGV0eXBlIjoxLCJtZXRlcmNoYW5uZWwiOjEsIm1ldGVybnVtIjoiMTIxOTEyMTMwMDA1NjIiLCJvcmdpZCI6IjAxMDc0MzIiLCJzaXRlaWQiOiIiLCJpY2NpZCI6Ijg5ODYwNDQ3MTExODgwNDQ4MjQ5IiwiZnVsbG9yZ2lkIjoiIiwiZGF0YXR5cGUiOjAsInNpZ25hbGxldmVsIjoyOSwibG9uZ2l0dWRlIjoiIiwibWVzc2FnZWlkIjoiIiwibWV0ZXJ0eXBlIjozMDEsImludGVydmFsIjo2MCwibGF0aXR1ZGUiOiIiLCJpbWVpIjoiODY2NzE0MDQwMTAzODk2IiwidmVyc2lvbiI6IjIuMi44In0=";
//	msg = msg.replace("ping", "");
//	System.out.println(msg.length());
//	byte[] bs = org.apache.commons.codec.binary.Base64.decodeBase64(msg);
//	System.out.println(new String(bs, "utf-8"));
	String s= ",1,2,,,,,";
	
	System.out.println(Arrays.asList(s.split(",")));
    }

    @Test
    public void test6() throws UnsupportedEncodingException {
	StringBuffer sb = new StringBuffer();
	if (sb.length() > 0 && !sb.toString().startsWith("ey"))
	    sb.setLength(0);
	sb.append(
		"NjI3LjMzLCJtZXNzYWdlaWQiOiIiLCJ0aW1lIjoxNTg2ODQxOTc5MDAwLCJmcm96ZW4iOjAsInNpZ25hbGxldmVsIjoyOSwibWV0ZXJudW0iOiIxMjE5MTIxMzAwMDU2MiIsImRhdGF0eXBlIjoyfQ==\r\n"
			+ "eyJsb29wMWt3aCI6MTYyNi40NSwia3doIjoxNjI2LjQ1LCJtZXNzYWdlaWQiOiIiLCJ0aW1lIjoxNTg2ODQwNDAwMDAwLCJmcm96ZW4iOjEsInNpZ25hbGxldmVsIjoyOSwibWV0ZXJudW0iOiIxMjE5MTIxMzAwMDU2MiIsImRhdGF0eXBlIjoyfQ==\r\n"
			+ "eyJsb29wMWt3aCI6MTYyNi40NSwia3doIjoxNjI2LjQ1LCJtZXNzYWdlaWQiOiIiLCJ0aW1lIjoxNTg2ODQwNDAwMDAwLCJmcm96ZW4iOjEsInNpZ25hbGxldmVsIjoyOSwibWV0ZXJudW0iOiIxMjE5MTIxMzAwMDU2MiIsImRhdGF0eXBlIjoyfQ==\r\n"
			+ "4eyJtZXRlcm51bSI6IjEyMTkxMjEzMDAwNTYyIiwidGltZXN0YW1wIjoxNTg2ODQxOTY4MDAwLCJtZXNzYWdlaWQiOiIiLCJkYXRhdHlwZSI6NH0=3eyJtb2R1bGV0eXBlIjoxLCJtZXRlcmNoYW5uZWwiOjEsIm1ldGVybnVtIjoiMTIxOTEyMTMwMDA1NjIiLCJvcmdpZCI6IjAxMDc0MzIiLCJzaXRlaWQiOiIiLCJpY2NpZCI6Ijg5ODYwNDQ3MTExODgwNDQ4MjQ5IiwiZnVsbG9yZ2lkIjoiIiwiZGF0YXR5cGUiOjAsInNpZ25hbGxldmVsIjoyOSwibG9uZ2l0dWRlIjoiIiwibWVzc2FnZWlkIjoiIiwibWV0ZXJ0eXBlIjozMDEsImludGVydmFsIjo2MCwibGF0aXR1ZGUiOiIiLCJpbWVpIjoiODY2NzE0MDQwMTAzODk2IiwidmVyc2lvbiI6IjIuMi44In0=1");
	List<String> base64list = getBase64String(sb.toString());
	if (base64list.size() > 0) {
	    for (int n = 0; n < base64list.size(); n++) {
		String base64 = base64list.get(n);
		if (n == base64list.size() - 1) {
		    if (!base64.endsWith("=")) {
			sb.setLength(0);
			sb.append(base64);
			break;
		    } else
			sb.setLength(0);
		}
		try {
		    base64 = new String(org.apache.tomcat.util.codec.binary.Base64.decodeBase64(base64), "utf-8")
			    .trim();
		    System.out.println(JSONObject.parse(base64));
		} catch (Exception e) {
		}
	    }
	}
    }

    private static List<String> getBase64String(String base64str) {
	List<String> list = new ArrayList<String>();
	if (base64str.isEmpty())
	    return list;
	String[] arr = base64str.split("ey");
	for (int n = 0; n < arr.length; n++) {
	    String str = arr[n].trim();
	    if (str.isEmpty() || "=".equals(str))
		break;
	    if (n == 0) {
		if (base64str.startsWith("ey"))
		    list.add("ey" + arr[n]);
	    } else {
		list.add("ey" + arr[n]);
	    }
	}
	return list;
    }
}
