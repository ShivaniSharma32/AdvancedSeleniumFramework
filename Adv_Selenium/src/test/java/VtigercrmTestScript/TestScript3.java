package VtigercrmTestScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript3 {


	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys("admin");
		driver.findElement(By.cssSelector("[name='user_password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Products']")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		String name="Apple";
		driver.findElement(By.cssSelector("[name='productname']")).sendKeys(name);
		
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		
		String text = driver.findElement(By.cssSelector("[id='dtlview_Product Name']")).getText();
		if(text.equals(name))
		{
			System.out.println("Product is Created");
		}
		else
		{
			System.out.println("Product not Created");
		}
		 driver.findElement(By.xpath("//td[@class='small'][1]//td[@class='small']")).click();
		 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
