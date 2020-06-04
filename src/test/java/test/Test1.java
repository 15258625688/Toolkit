package test;

import java.util.Arrays;

import org.junit.Test;

import com.toolkit.util.ByteUtil;

public class Test1 {

    @Test
    public void test1() throws Exception {
	byte[] bs = ByteUtil.hexToBytes("E101");
	System.out.println(Arrays.toString(bs));
	int n = (bs[0] << 8 & 0xff00) | (bs[1]);
	System.out.println(n);
	System.out.println((n - 2731) / 10.0);
    }
}
