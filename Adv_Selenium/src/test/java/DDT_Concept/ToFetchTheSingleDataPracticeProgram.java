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

public class ToFetchTheSingleDataPracticeProgram {


	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	//	WebDriver driver = new ChromeDriver();
		
		FileInputStream fis = new FileInputStream("./src/test/resources/Book1.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sh = book.getSheet("Sheet1");
		
		Row ro = sh.getRow(0);
		
		Cell cel = ro.getCell(0);
		
		String data = cel.toString(); //...It will give decimal value 
		
		//DataFormatter format = new DataFormatter();
		//String data = format.formatCellValue(cel);
		System.out.println(data);

	}

}
