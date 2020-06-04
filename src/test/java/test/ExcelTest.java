package test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import com.toolkit.util.ExcelUtil;

public class ExcelTest {

	@Test
	public void test1() throws FileNotFoundException, IOException {
		Workbook workbook = new HSSFWorkbook(new FileInputStream("F:\\站点模版 (1).xls"));
		ExcelUtil.ExcelData excelData = ExcelUtil.readExcel(workbook);
		System.out.println(excelData);
		FileOutputStream fos = new FileOutputStream("F:\\" + new Date().getTime() + ".xls");
		ByteArrayOutputStream bos = ExcelUtil.getExcelByteArrayOutputStream(excelData);
		fos.write(bos.toByteArray());
		fos.close();
	}
}
