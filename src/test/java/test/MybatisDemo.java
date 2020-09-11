package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.net.ssl.SSLSession;

public class MybatisDemo {
    public static void main(String[] args) {
	MybatisTest test = (MybatisTest) Proxy.newProxyInstance(MybatisTest.class.getClassLoader(), new Class[] { MybatisDemo.class },
		new InvocationHandler() {

		    @Override
		    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			method.getName();
			return null;
		    }
		});
    }
}
