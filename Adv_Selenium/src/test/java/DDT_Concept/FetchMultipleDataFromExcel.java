package DDT_Concept;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchMultipleDataFromExcel {



	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	 
	WebDriver	driver=new ChromeDriver();
	
	FileInputStream fis = new FileInputStream("./src/test/resources/MyExcelData.xlsx");
	
	Workbook book = WorkbookFactory.create(fis);
	
	Sheet sh = book.getSheet("Sheet2");
	
	int row = sh.getLastRowNum();

	for(int i=0; i<row; i++)
	{
		Row ro = sh.getRow(i);
		short cel = ro.getLastCellNum();
		
		for(int j=0; j<cel ;j++)
		{
			Cell cell = ro.getCell(j);
			DataFormatter Format = new DataFormatter();
			String data = Format.formatCellValue(cell);
			System.out.println(data);
		}	
		
	}
	
	}

}
