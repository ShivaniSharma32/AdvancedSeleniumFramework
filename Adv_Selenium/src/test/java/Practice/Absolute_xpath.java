package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Absolute_xpath {

	public static void main(String[] args) {
	
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("file:///C:/Users/dell/Downloads/Locators%20demo.html");
		
		driver.findElement(By.xpath("/html/body/div[2]/form/input[1]")).sendKeys("Shivani");
		driver.findElement(By.xpath("/html/body/div[2]/form/input[2]")).sendKeys("Sharma");
		driver.findElement(By.xpath("/html/body/div[2]/form/input[4]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/form/input[6]")).sendKeys("Shi123");
		driver.findElement(By.xpath("/html/body/div[2]/form/input[7]")).sendKeys("Shiv@3");
		driver.findElement(By.xpath("/html/body/div[2]/form/button[1]")).submit();
	}

}
