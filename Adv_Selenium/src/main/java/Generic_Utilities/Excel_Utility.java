package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	public String getExcelData(String SheetName, int rownum, int cellnum) throws Throwable, IOException {
		
		FileInputStream fes = new FileInputStream("./src/test/resources/TestData.xlsx");
		  Workbook book = WorkbookFactory.create(fes);
		  Sheet sheet = book.getSheet(SheetName);
		 Row ro = sheet.getRow(rownum);
		 Cell cel = ro.getCell(cellnum);
		String ExcelData = cel.getStringCellValue();
		return ExcelData;
		
	}

	public String getExcelDataUsingDataFormatter(String SheetName, int rownum, int cellnum) throws Throwable
	{
		FileInputStream fes = new FileInputStream("./src/test/resources/TestData.xlsx");
		  Workbook book = WorkbookFactory.create(fes);
		  Sheet sheet = book.getSheet(SheetName);
		 Row ro = sheet.getRow(rownum);
		 Cell cel = ro.getCell(cellnum);
		 DataFormatter format = new DataFormatter();
		 String ExcelData =format.formatCellValue(cel);
		 return ExcelData;
	}
	

	public Object[][] getDataProvider(String SheetName) throws Throwable, IOException {
		
		FileInputStream fes = new FileInputStream("./src/test/resources/TestData.xlsx");
		  Workbook book = WorkbookFactory.create(fes);
		  Sheet sheet = book.getSheet(SheetName);
		  int lastRow = sheet.getPhysicalNumberOfRows();
		// int lastRow = sheet.getLastRowNum()+1;
		// short lastcell = sheet.getRow(0).getLastCellNum();
		  int lastcell = sheet.getRow(0).getPhysicalNumberOfCells();
		  
		 Object[][] obj= new Object[lastRow][lastcell];
		for(int i=0; i<lastRow;i++)
		{
			for(int j=0; j<lastcell;j++)
			{
				obj[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return obj;
		
	}
}
