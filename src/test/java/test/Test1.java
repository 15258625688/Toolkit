package test;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import org.junit.Test;

import com.toolkit.util.ByteUtil;

public class Test1 {

    private static long l = System.currentTimeMillis();

    public static long getLong() {
	return l;
    }

    @Test
    public void test1() throws Exception {
	List<String> ipList = new ArrayList<String>();
	Enumeration<NetworkInterface> netInterfaces = null;
	try {
	    netInterfaces = NetworkInterface.getNetworkInterfaces();
	    while (netInterfaces.hasMoreElements()) {
		NetworkInterface ni = netInterfaces.nextElement();
		Enumeration<InetAddress> ips = ni.getInetAddresses();
		while (ips.hasMoreElements()) {
		    InetAddress ip = ips.nextElement();
		    if (ip.isSiteLocalAddress()) {
			ipList.add(ip.getHostAddress());
		    }
		}
	    }
	} catch (Exception e) {
	}
	System.out.println(ipList);
    }
}
