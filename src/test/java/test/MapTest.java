package test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MapTest {

    @Test
    public void test1() {
	Map<Integer, Object> map = new HashMap<Integer, Object>();
	for (int n = 0; n < 10; n++)
	    map.put(n, new Object());
	
    }
}
