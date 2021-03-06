package com.gtpl.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	private FileInputStream fis;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	//private XSSFRow row;
	//private XSSFCell cell;
	
	
	
	public ReadExcel(String filePath,String sheetName) {
		
		try {
			 fis=new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			workbook=new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet=workbook.getSheet(sheetName);
	}
	
	
	public int getRowCount() {
		int rowCount=sheet.getLastRowNum();
		return rowCount;
	}
	
	public int getColumnCount() {
		int columnCount=sheet.getRow(1).getLastCellNum();
		return columnCount;
		
	}
	
	public String getCellData(int rowNum,int colNum) {
		
		if(CellType.STRING==sheet.getRow(rowNum).getCell(colNum).getCellType()) {
			String data=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			return data;
		}
		else if(CellType.NUMERIC==sheet.getRow(rowNum).getCell(colNum).getCellType()) {
			long data=(long)sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			
			return String.valueOf(data);
		}
		
		return null;
		
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * ReadExcel readExcel=new ReadExcel(
	 * "B:\\project\\GTPLBankAutomation_UI\\src\\main\\java\\com\\gtpl\\qa\\testdata\\NewCustomerTestData.xlsx",
	 * "customerdata"); System.out.println(readExcel.getCellData(1, 0));
	 * System.out.println(readExcel.getCellData(1, 1));
	 * System.out.println(readExcel.getCellData(1, 2));
	 * System.out.println(readExcel.getCellData(1, 3));
	 * System.out.println(readExcel.getCellData(1, 4));
	 * System.out.println(readExcel.getCellData(1, 5));
	 * System.out.println(readExcel.getCellData(1, 6));
	 * System.out.println(readExcel.getCellData(1, 7));
	 * System.out.println(readExcel.getCellData(1, 8));
	 * System.out.println(readExcel.getCellData(1, 9));
	 * 
	 * }
	 */
}
