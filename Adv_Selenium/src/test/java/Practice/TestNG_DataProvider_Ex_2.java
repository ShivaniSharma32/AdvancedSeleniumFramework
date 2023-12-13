package Practice;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.Excel_Utility;

// Pass the data by using Data provider in the Organization (pass Organisation name, phone, email)

public class TestNG_DataProvider_Ex_2 {
	
@Test(dataProvider="getData")
public void m1(String orgname, String phoneNum, String email) throws Throwable
{
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
		Random r = new Random();
int ranNum = (r.nextInt(1000));
String name= orgname+ranNum;

	  driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(name);
		 Thread.sleep(2000);
		 driver.findElement(By.cssSelector("[id='phone']")).sendKeys(phoneNum);
		 Thread.sleep(2000);
		 driver.findElement(By.cssSelector("[id='email1']")).sendKeys(email);
		 Thread.sleep(2000);
	 driver.findElement(By.xpath("//input[@accesskey='S']")).click();
	 Thread.sleep(2000);
	 String Organization_name = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
	 
	 Thread.sleep(3000);
	
	 if(Organization_name.equals(orgname))
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
		 Thread.sleep(2000);
		 driver.quit();
}

@DataProvider
public Object[][] getData() throws IOException, Throwable
{
	
	Excel_Utility e= new Excel_Utility();
	
	Object[][] value = e.getDataProvider("Sheet2");
	return value;
	
//	Random r = new Random();
//	int ranNum = (r.nextInt(1000));
//	Object[][] obj= new Object[3][3];
//	
//	obj[0][0]="AAA"+ranNum;
//	obj[0][1]="23123144";
//	obj[0][2]="jher@gmail.com";
//	
//	obj[1][0]="BBB"+ranNum;
//	obj[1][1]="23455555";
//	obj[1][2]="iefh@gmail.com";
//	
//	obj[2][0]="CCC"+ranNum;
//	obj[2][1]="23424422";
//	obj[2][2]="erwc@gmail.com";
//	return obj;
	}


}
