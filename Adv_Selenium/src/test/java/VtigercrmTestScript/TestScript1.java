package VtigercrmTestScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript1 {


	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys("admin");
		driver.findElement(By.cssSelector("[name='user_password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		 driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		 Thread.sleep(2000);
		 String name= "Qspider39";
		  driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(name);
			 Thread.sleep(2000);
		
		 driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		 Thread.sleep(2000);
		 String Organization_name = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		 
		 Thread.sleep(3000);
		
		 if(Organization_name.equals(name))
		 {
			 System.out.println("Organization is Created in Organization page Succefully");
		 }
		 else
		 {
			 System.out.println("Not created");
		 }
		 driver.findElement(By.xpath("//td[@class='small'][1]//td[@class='small']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		 
		 

	}

}
