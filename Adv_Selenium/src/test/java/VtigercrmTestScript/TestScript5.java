package VtigercrmTestScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestScript5 {


	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys("admin");
		driver.findElement(By.cssSelector("[name='user_password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		WebElement element = driver.findElement(By.xpath("//a[text()='More']"));
		Actions ac= new Actions(driver);
		ac.moveToElement(element).click().perform();
		driver.findElement(By.cssSelector("[name='Campaigns']")).click();
		driver.findElement(By.cssSelector("[title='Create Campaign...']")).click();
		
		driver.findElement(By.cssSelector("[title='Select']")).click();

		
		
		
		String caName="YETER";
		driver.findElement(By.cssSelector("[name='campaignname']")).sendKeys(caName);
		
		 driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		
		 String Campaignname = driver.findElement(By.cssSelector("[id='dtlview_Campaign Name']")).getText();
		 Thread.sleep(3000);
		if(Campaignname.equals(caName))
		{
			System.out.println("Campaignname Created Successfully");
		}
		else
		{
			System.out.println("Campaignname Not created");
		}
		 driver.findElement(By.xpath("//td[@class='small'][1]//td[@class='small']")).click();
		 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
	}

}
