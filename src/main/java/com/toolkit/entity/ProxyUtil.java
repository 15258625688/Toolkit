package com.toolkit.entity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    @SuppressWarnings("unchecked")
    public static <T> T newProxy(Class<T> class1) {
	return (T) Proxy.newProxyInstance(class1.getClassLoader(), new Class[] { class1 }, new InvocationHandler() {
	    @Override
	    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return "method:" + method.getName() + ",methodParam" + args;
	    }
	});
    }
}
