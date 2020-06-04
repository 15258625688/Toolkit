package test;

import org.junit.Test;

import com.toolkit.util.CXFUtil;

public class CXFTest {

    String params = "<Request>\n" + "    <PK_Type>\n" + "        <Name>LOGIN</Name>\n" + "        <Code>101</Code>\n"
	    + "    </PK_Type>\n" + "    <Info>\n" + "        <UserName>chinaunicom</UserName>\n"
	    + "        <PassWord>chinaunicom</PassWord>\n" + "        <SUId>46-8E-82-55-2E-66</SUId>\n"
	    + "        <SURId>46-8E-82-55-2E-77</SURId>\n" + "        <SUIP>172.16.4.46</SUIP>\n"
	    + "        <SUPort>8080</SUPort>\n" + "        <SUVendor>浙江创力电子股份有限公司</SUVendor>\n"
	    + "        <SUModel>MPSU_1_0</SUModel>\n" + "        <SUHardVer>1.0.1</SUHardVer>\n"
	    + "        <SUVer>1.01</SUVer>\n" + "        <SUConfigTime>2019-06-17 17:49:12</SUConfigTime>\n"
	    + "        <DeviceList>\n" + "            <Device Id=\"00016\" RId=\"00016\" />\n"
	    + "            <Device Id=\"28101\" RId=\"28101\" />\n"
	    + "            <Device Id=\"28102\" RId=\"28102\" />\n"
	    + "            <Device Id=\"28103\" RId=\"28103\" />\n"
	    + "            <Device Id=\"28104\" RId=\"28104\" />\n"
	    + "            <Device Id=\"2A101\" RId=\"2A101\" />\n"
	    + "            <Device Id=\"2A102\" RId=\"2A102\" />\n"
	    + "            <Device Id=\"2A103\" RId=\"2A103\" />\n"
	    + "            <Device Id=\"2A104\" RId=\"2A104\" />\n"
	    + "            <Device Id=\"41901\" RId=\"41901\" />\n"
	    + "            <Device Id=\"60101\" RId=\"60101\" />\n"
	    + "            <Device Id=\"60102\" RId=\"60102\" />\n"
	    + "            <Device Id=\"60103\" RId=\"60103\" />\n"
	    + "            <Device Id=\"60104\" RId=\"60104\" />\n"
	    + "            <Device Id=\"60105\" RId=\"60105\" />\n"
	    + "            <Device Id=\"91101\" RId=\"91101\" />\n" + "        </DeviceList>\n" + "    </Info>\n"
	    + "</Request>\n";

    @Test
    public void test1() throws Exception {
	Object object = CXFUtil.clientInvoke("http://180.153.49.108:58080/services/OpenDoorLogReceive?wsdl",
		"http://impl.wsserver.fik.tower.com", "entranceLog", "");
	System.out.println(object.getClass());
	if (object instanceof String)
	    System.out.println((String) object);
	else
	    System.out.println(object);
    }
}
