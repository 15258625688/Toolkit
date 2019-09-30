package test;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentException;
import org.junit.Test;

import com.toolkit.entity.Device;
import com.toolkit.entity.Info;
import com.toolkit.entity.Request;
import com.toolkit.util.XMLUtil;

public class Dom4JTest {

	@Test
	public void test1() throws DocumentException {
		Request request = new Request();
		Info info = new Info();
		info.setUserName("zhh");
		info.setPassWord("pass");
		info.setSuConfigTime("dsada");
		info.setSuHardVer("sdadsa");
		List<Device> list = new ArrayList<Device>();
		for (int n = 1; n < 3; n++) {
			Device device = new Device();
			device.setId("id" + n);
			device.setrId("rid" + n);
			list.add(device);
		}
		info.setDeviceList(list);
		request.setInfo(info);
		String xml = XMLUtil.objectToXml(request);
		System.out.println(xml);
		Request request2 = XMLUtil.xmlToObject(Request.class, xml);
		System.out.println(request2);
	}
}
