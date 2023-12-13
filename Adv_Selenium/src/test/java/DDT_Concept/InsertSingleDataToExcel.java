package DDT_Concept;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertSingleDataToExcel {

	

	public static void main(String[] args) throws Throwable {
	   
		
		//create the object of FileInputStream to fetch the file from the external resources 
		FileInputStream fis = new FileInputStream("./src/test/resources/MyExcelData.xlsx");
		
		// Open WorkBook in read mode, Workbbokfactory is used to read data from the excelsheet 
		Workbook book = WorkbookFactory.create(fis);
		
		//to get the Sheet
		Sheet sh = book.getSheet("Sheet1");
		
		// to create the row
		Row ro = sh.createRow(3);
		
		//to create the cell
		Cell cel = ro.createCell(4);
		
		// to set the value in excel
		cel.setCellValue("Qspider");
		
		//create the object of fileoutputstream to write in excel sheet
		FileOutputStream fos = new FileOutputStream("./src/test/resources/MyExcelData.xlsx");
		
		//workbook in write mode
		book.write(fos);
		
		
		//close the file
		fos.flush();
		
		
		

	}

}
