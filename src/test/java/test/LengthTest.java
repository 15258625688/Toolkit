package test;

import com.toolkit.util.ByteUtil;

public class LengthTest {

	public static void main(String[] args) {
		int n=0;
		System.out.println(n);
		byte[] b=ByteUtil.getL_TH(n);
		System.out.println(ByteUtil.bytesToHexString(ByteUtil.bytesToHexString(b).getBytes()));
	}
	
}