package com.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test_datare {
	public static void main (String args[])throws Exception {
	FileInputStream fis=new FileInputStream("E:\\Selenium_Student_SW\\WriteData.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet sheet=wb.getSheet("test");
	System.out.println(sheet.getSheetName());
	System.out.println(sheet.getLastRowNum());
	System.out.println("before adding cellData"+sheet.getRow(2).getCell(1));
	XSSFCell cell=sheet.getRow(2).getCell(1);
	cell.setCellValue("seleni123");
	
	FileOutputStream fo=new FileOutputStream("E:\\Selenium_Student_SW\\ReadExcel.xls");
	wb.write(fo);
	System.out.println("afteradding cellData"+cell.getStringCellValue());


}
}
