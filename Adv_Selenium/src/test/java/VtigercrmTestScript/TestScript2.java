package VtigercrmTestScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestScript2 {



	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys("admin");
		driver.findElement(By.cssSelector("[name='user_password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Contacts']")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		WebElement element = driver.findElement(By.cssSelector("[name='salutationtype']"));
		
		Select s = new Select(element);
		s.selectByValue("Ms.");
		
        String name = "Shivani3";
		driver.findElement(By.cssSelector("[name='firstname']")).sendKeys(name);
		
		String lname="Sharma3";
		driver.findElement(By.cssSelector("[name='lastname']")).sendKeys(lname);
		
		 driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		 
		String Firstname = driver.findElement(By.cssSelector("[id='dtlview_First Name']")).getText();
		 Thread.sleep(3000);
		if(Firstname.equals(name))
		{
			System.out.println("FirstName Created Successfully");
		}
		else 
		{
			System.out.println("FirstName not created");
		}
		
		String lastname = driver.findElement(By.cssSelector("[id='dtlview_Last Name']")).getText();
		 Thread.sleep(3000);
		if(lastname.equals(lname))
		{
			System.out.println("LastName Created Successfully");
		}
		else
		{
			System.out.println("LastName Not created");
		}
		 driver.findElement(By.xpath("//td[@class='small'][1]//td[@class='small']")).click();
		 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
