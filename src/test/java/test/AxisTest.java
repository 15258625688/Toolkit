package test;

import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.Call;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.encoding.XMLType;

import org.apache.axis.client.Service;
import org.junit.Test;

public class AxisTest {

    @Test
    public void test1() throws ServiceException, RemoteException {
	Service service = new Service();
	Call call = service.createCall();
	// 设置访问地址
	call.setTargetEndpointAddress("http://180.153.49.108:58080/services/OpenDoorLogReceive?wsdl");
	// 设置访问接口
	call.setOperationName(new QName("http://impl.wsserver.fik.tower.com", "entranceLog"));
	// 设置参数访问格式
	call.addParameter("msg", XMLType.XSD_STRING, ParameterMode.IN);

	// 设置返回类型
	call.setReturnType(XMLType.XSD_STRING);
	// 发送json数据请求
//	JSONObject json = JSONObject.parseObject(
//		"\"firmSign\":\"MakePower\",\"operationId\":\"33030200002167\",\"openUserName\":\"Android测试\",\"openUserPhone\":\"13711111111\",\"openUserCompany\":\"创力股份-创力股份_测试部\",\"openType\":\"ThirdPartyAPP\",\"openTime\":\"2020-04-08 00:30:17\",\"openCause\":\"\",\"openResult\":\"true\"");

	String result = (String) call.invoke(new Object[] {"{\"firmSign\":\"MakePower\",\"operationId\":\"33030200002167\",\"openUserName\":\"Android测试\",\"openUserPhone\":\"13711111111\",\"openUserCompany\":\"创力股份-创力股份_测试部\",\"openType\":\"ThirdPartyAPP\",\"openTime\":\"2020-04-08 00:30:17\",\"openCause\":\"\",\"openResult\":\"true\"}" });
	System.out.println("result is " + result);
//	System.out.println(json);
	System.out.println(call);
    }
}
