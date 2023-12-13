package DDT_Concept;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertDataToPropertiesFile {



	public static void main(String[] args) throws IOException {
	WebDriver	driver =new ChromeDriver();
   
	Properties pob= new Properties();
	pob.setProperty("user_name", "standard_user");
	pob.setProperty("Pass_word", "secret_sauce");
	pob.setProperty("ur_l", "url https://www.saucedemo.com/v1/");
	 
	FileOutputStream fos = new FileOutputStream("./src/test/resources/PropertiesFile.properties");
	pob.store(fos, "Common data" );
	System.out.println("Done Successfully");
	
	
	}

}
