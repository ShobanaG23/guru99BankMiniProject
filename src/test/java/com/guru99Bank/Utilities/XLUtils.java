package com.guru99Bank.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XLUtils{

	public static FileInputStream fis;
	public static FileOutputStream fo;
	public static Workbook wb;
	public static Sheet sh;
	public static Row row;
	public static Cell cell;
	
	
	
	public static int getRowCount(String xlfile,String sheetName) throws InvalidFormatException, IOException{    
	      fis = new FileInputStream(xlfile);
	      wb = WorkbookFactory.create(fis);
	      sh = wb.getSheet(sheetName);
	      int rowCount = sh.getLastRowNum();
	      return rowCount;
	}

	public static int getcellCount(String xlfile,String sheetName,int rowNum) throws InvalidFormatException, IOException{
	      fis = new FileInputStream(xlfile);
	      wb = WorkbookFactory.create(fis);
	      sh = wb.getSheet(sheetName);    
	      row = sh.getRow(rowNum);
	      int  cellCount = row.getLastCellNum();
	     return cellCount ;     
	}
	
	public static String getExcelData(String xlfile,String sheetName , int rowNum , int colNum) throws InvalidFormatException, IOException{
	      fis = new FileInputStream(xlfile);
	      wb = WorkbookFactory.create(fis);
	      sh = wb.getSheet(sheetName);    
	      row = sh.getRow(rowNum);
	      String data = row.getCell(colNum).getStringCellValue();
	      return data;
	}
	
}
