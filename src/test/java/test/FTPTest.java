package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Before;
import org.junit.Test;

import com.toolkit.util.FtpClient;

public class FTPTest {

    FtpClient client = new FtpClient("60.190.73.158", 6221, "ftp123", "cldz2019");

    @Before
    public void before() {
	boolean isconnect = client.connect();
	System.out.println(isconnect);
    }

    @Test
    public void ftp() throws IOException {
	OutputStream os = client.download("/data/data.csv");
	if (os != null) {
	    if (os instanceof ByteArrayOutputStream) {
		InputStream is = new ByteArrayInputStream(((ByteArrayOutputStream) os).toByteArray());
		try {
		    FileOutputStream fs = new FileOutputStream(new File("F:/test/data.csv"));
		    byte[] bytes = new byte[8 * 1024];
		    int n = -1;
		    while ((n = is.read(bytes)) > -1)
			fs.write(bytes, 0, n);
		    is.close();
		    fs.close();
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		}
	    }
	}
    }

    @Test
    public void delete() {
	System.out.println(client.deleteFile("/data", "test.txt"));
    }
}
