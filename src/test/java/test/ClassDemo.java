package test;

import com.toolkit.util.ProxyUtil;

public class ClassDemo {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, Throwable {
	Demo demo = (Demo) ProxyUtil.newProxyInstance(new ClassDemo());
    }

    public void test() {
	System.out.println("test");
    }
}
