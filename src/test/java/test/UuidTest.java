package test;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.junit.Test;

public class UuidTest {

    @Test
    public void test0() {
	Calendar c = Calendar.getInstance();
	System.out.println(c.get(Calendar.HOUR_OF_DAY));
	System.out.println(c.get(Calendar.MINUTE));
    }

    @Test
    public void test1() {
	String uuid = UUID.randomUUID().toString().replaceAll("-", "");
	System.out.println(uuid.length());
	System.out.println(uuid);
	System.out.println(File.separator);
	System.out.println(File.pathSeparator);
    }
}
