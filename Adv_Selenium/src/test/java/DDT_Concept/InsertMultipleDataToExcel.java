package DDT_Concept;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertMultipleDataToExcel {

	

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	 WebDriver driver	=new ChromeDriver();
		 FileInputStream fis = new FileInputStream("./src/test/resources/MyExcelData.xlsx");
		 
		  Workbook book = WorkbookFactory.create(fis);
		  
		 Sheet sh = book.getSheet("Sheet2");
		 
		 driver.get("https://www.amazon.com/");
		 
		List<WebElement> AllLinks = driver.findElements(By.xpath("//a"));
		 
		int count = AllLinks.size();
		 
		for(int i=0; i<count ;i++)
		{
			 Row ro = sh.createRow(i);
			 Cell cel = ro.createCell(0);
			 cel.setCellValue(AllLinks.get(i).getAttribute("href"));
		}
		
      FileOutputStream fos = new FileOutputStream("./src/test/resources/MyExcelData.xlsx");
      book.write(fos);
      fos.flush();
      
	}

}
