package com.toolkit.util;

import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class CXFUtil {
    /**
     * 
     * @param wsdlUrl      the URL to load
     * @param namespaceURI Namespace URI of the QName
     * @param localPart    local part of the QName
     * @param params       The params that matches the parts of the input message of
     *                     the operation. If the BindingOperationInfo supports
     *                     unwrapping, it assumes the params are in the "unwrapped"
     *                     form. If params are in the wrapped form, use
     *                     invokeWrapped
     * @return
     * @throws Exception
     */
    public static Object clientInvoke(String wsdlUrl, String namespaceURI, String localPart, Object params)
	    throws Exception {
	JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
	Client client = factory.createClient(wsdlUrl);
	QName qName = new QName(namespaceURI, localPart);
	Object[] objs = client.invoke(qName, params);
	if (objs.length == 1)
	    return objs[0];
	return objs;
    }
}
