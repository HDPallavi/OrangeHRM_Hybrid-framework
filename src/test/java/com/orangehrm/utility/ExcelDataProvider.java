
package com.orangehrm.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author pallavi
 *
 */
public class ExcelDataProvider 
{
	XSSFWorkbook wb;
	public ExcelDataProvider() 
	{
		File src=new File("./testdata/Data.xlsx");
		try {
		FileInputStream fis= new FileInputStream(src);
		wb=new XSSFWorkbook(fis);
		}
		catch(Exception e) 
		{
			System.out.println("Unable to read excel file"+e.getMessage());
		}
	}
	
	public String getStringData(int sheetIndex,int row,int column) 
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(String sheetName,int row,int column) 
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	public double getNumericData(String sheetName,int row,int column) 
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
	public int getNumericCellData(String sheetName,int row,int column) 
	{
		return (int) wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
	

	
}
