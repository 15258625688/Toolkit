package test.cwb;

import org.junit.Test;

public class test {
    @Test
    public void test1() {
	int a = 0, b = 0;
	for (int n = 0; n < 99; n++) {
	    b = ++b;
	}
	System.out.println(a);
	System.out.println(b);
    }
}
