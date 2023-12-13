package VtigercrmTestScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestScript6 {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys("admin");
		driver.findElement(By.cssSelector("[name='user_password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		 driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();
		 
		 driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		 
		 String name= "Qspider4";
		  driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(name);
		   
		 WebElement element = driver.findElement(By.cssSelector("[name='industry']"));
		 Select s = new Select(element);
		 s.selectByValue("Banking");
		 
		 WebElement element2 = driver.findElement(By.cssSelector("[name='accounttype']"));
		 Select s1 = new Select(element2);
		 s1.selectByValue("Analyst");
		 
driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		 
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
		 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
