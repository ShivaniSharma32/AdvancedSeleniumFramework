package DDT_Concept;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromPropertiesFile {


	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();

		 FileInputStream fis = new FileInputStream("./src/test/resources/ReadPropertiesFile.properties");
		 
		 Properties pob= new Properties();
		 pob.load(fis);
		 
		String URL = pob.getProperty("url");
		
		driver.get(URL);
		 String USERNAME = pob.getProperty("username");
		 String PASSWORD = pob.getProperty("password");
		 
		 driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		 driver.findElement(By.id("password")).sendKeys(PASSWORD);
		 driver.findElement(By.id("login-button")).click();
		 
		
		
		
		
		
		
		
	}

}
