package test;

import java.io.File;
import java.lang.Package;
import java.util.ArrayList;
import java.util.List;

public class PackageTest {
    public static void main(String[] args) {
	String pName = "test";
	List<Class<?>> clist = new ArrayList<Class<?>>();
    }

    public void showClass(String pName, List<Class<?>> clist) {
	File file = new File(pName.replace(".", "/"));
	if (file != null) {

	}
    }
}
