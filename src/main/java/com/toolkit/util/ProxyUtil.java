package com.toolkit.util;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {

    public static Object newProxyInstance(Object object) {
	return Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(), object.getClass().getInterfaces(),
		(Object proxy, Method method, Object[] args) -> {
		    System.out.println(object.getClass());
		    return method.invoke(object, args);
		});
    }
}
