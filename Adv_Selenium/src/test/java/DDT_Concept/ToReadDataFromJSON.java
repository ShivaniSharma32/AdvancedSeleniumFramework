package DDT_Concept;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ToReadDataFromJSON {

	

	public static void main(String[] args) throws Throwable {
		File fis = new File("./src/test/resources/JasonFile.json");
		    
	ObjectMapper object = new	ObjectMapper();
	JsonNode jsonData = object.readTree(fis);
	
	String URL = jsonData.get("url").asText();
	
	WebDriver driver = new ChromeDriver();
	
	driver.get(URL);
		
	String USERNAME = jsonData.get("username").asText();
	driver.findElement(By.id("user-name")).sendKeys(USERNAME);
	}

}
