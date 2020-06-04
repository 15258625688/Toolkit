package com.toolkit.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelUtil {
	public static ExcelUtil.ExcelData readExcel(Workbook wb) {
		if (wb == null)
			return null;
		ExcelData excelData = new ExcelData();
		List<String> title = new ArrayList<String>();
		excelData.setTitle(title);
		List<List<String>> data = new ArrayList<List<String>>();
		excelData.setData(data);
		Sheet sheet = wb.getSheetAt(0);
		int rowNum = sheet.getLastRowNum();
		if (rowNum == 0)
			// 没有数据
			return excelData;
		for (int n = 0; n <= rowNum; n++) {
			Row row = sheet.getRow(n);
			short cellNum = row.getLastCellNum();
			List<String> listData = new ArrayList<String>();
			for (int i = 0; i < cellNum; i++)
				listData.add(row.getCell(i).getStringCellValue());
			if (n == 0)
				excelData.setTitle(listData);
			else
				data.add(listData);
		}
		return excelData;
	}

	public static ByteArrayOutputStream getExcelByteArrayOutputStream(ExcelData excelData) {
		Workbook workbook = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			workbook = new HSSFWorkbook();
			Sheet sheet = workbook.createSheet();
			int sizeColumn = 0;
			int rownum = 0;
			short cellnum = 0;
			Row row = sheet.createRow(rownum++);
			CellStyle headerStyle = workbook.createCellStyle(); // 标题样式
			for (String s : excelData.getTitle()) {
				headerStyle.setAlignment(HorizontalAlignment.CENTER);
				headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
				Font headerFont = workbook.createFont(); // 标题字体
				headerFont.setFontHeightInPoints((short) 11);
				headerFont.setBold(true);
				headerStyle.setFont(headerFont);
				Cell cell = row.createCell(cellnum);
				cell.setCellStyle(headerStyle);
				cell.setCellValue(s);
				if (cellnum > sizeColumn)
					sizeColumn = cellnum;
				cellnum++;
			}
			CellStyle style = workbook.createCellStyle();
			for (List<String> listdata : excelData.getData()) {
				cellnum = 0;
				row = sheet.createRow(rownum++);
				for (String s : listdata) {
					style.setAlignment(HorizontalAlignment.CENTER);
					style.setVerticalAlignment(VerticalAlignment.CENTER);
					Cell cell = row.createCell(cellnum);
					cell.setCellStyle(style);
					cell.setCellValue(s);
					if (cellnum > sizeColumn)
						sizeColumn = cellnum;
					cellnum++;
				}
			}
			for (int c = 0; c <= sizeColumn; c++) {
				sheet.autoSizeColumn(c);
				sheet.setColumnWidth(c, sheet.getColumnWidth(c) * 17 / 10);
			}
			workbook.write(bos);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (workbook != null)
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return bos;
	}

	public static class ExcelData implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 8603204682344189362L;
		List<String> title;
		List<List<String>> data;

		public List<String> getTitle() {
			return title;
		}

		public void setTitle(List<String> title) {
			this.title = title;
		}

		public List<List<String>> getData() {
			return data;
		}

		public void setData(List<List<String>> data) {
			this.data = data;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (String s : title)
				sb.append(s + "\t");
			sb.append("\r\n");
			for (List<String> list : data) {
				for (String s : list)
					sb.append(s + "\t");
				sb.append("\r\n");
			}
			return sb.toString();
		}

	}
}
