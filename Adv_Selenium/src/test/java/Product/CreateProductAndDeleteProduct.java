package Product;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utiltity;
import PomRepository.Home_Page;
import PomRepository.Login_Page;
import PomRepository.Product_Module_Page;

public class CreateProductAndDeleteProduct extends BaseClass{

	@Test
	public void CreateProductAndDeleteProductTest() throws Throwable
	{

	//public static void main(String[] args) throws Throwable {
		//WebDriver driver = new ChromeDriver();
		
//		-------Written in before class of TestNG --- no need to write in script--------
	WebDriver_Utiltity wb= new WebDriver_Utiltity();
//		wb.maximizingWindow(driver);
//		wb.minimizingWindow(driver);
//		wb.ImplicitWait(driver);
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		-------Written in before class of TestNG --- no need to write in script--------		
//		File_Utility flib= new File_Utility();
//		String URL = flib.getKeyAndValue("url");
//		String USERNAME =flib.getKeyAndValue("username");
//		String PASSWORD = flib.getKeyAndValue("password");
		//driver.get(URL);
		
//		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(USERNAME);
//		driver.findElement(By.cssSelector("[name='user_password']")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		//Access by using Business Logics 
		//-- Written in TestNG Before Method as well	
//		 Login_Page lg= new Login_Page(driver);
//		 lg.loginToApplication(USERNAME, PASSWORD);
//		
		
//		driver.get("http://localhost:8888/");
//		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys("admin");
//		driver.findElement(By.cssSelector("[name='user_password']")).sendKeys("admin");
//		driver.findElement(By.id("submitButton")).click();
		 
		//Using Object creation of POM classes
		 Home_Page hp= new  Home_Page(driver);
		 Product_Module_Page pm= new Product_Module_Page(driver);
		 
		pm.clickOnProduct();
		//driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Products']")).click();
		
		pm.clickOnCreateProduct();
		//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		
		 Java_Utility ju= new Java_Utility();
		 int rannum = ju.getRandomNum();
		
//		Random rc= new Random();
//		int rannum = rc.nextInt(1000);
		 
		 Excel_Utility elib = new Excel_Utility();
		 String name = elib.getExcelData("Product", 0, 0)+rannum;
		
		//String name="Apple"+rannum;
		 
		 pm.clickOnProductName(name);
		//driver.findElement(By.cssSelector("[name='productname']")).sendKeys(name);
		
		 hp.clickOnSave();
		//driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		
		 pm.clickOnCheckProduct();
		//String text = driver.findElement(By.cssSelector("[id='dtlview_Product Name']")).getText();
		if(pm.clickOnCheckProduct().equals(name))
		{
			System.out.println("Product is Created");
		}
		else
		{
			System.out.println("Product not Created");
		}
		
		hp.clickProduct();
		//driver.findElement(By.xpath("(//a[text()='Products'])[1]")).click();
		
		pm.dynamicXpath(driver, name);
	//	driver.findElement(By.xpath("//a[text()='"+name+"']/../preceding-sibling::td/input")).click();
		
		hp.clickOnDelete();
	//	driver.findElement(By.xpath("//input[@value='Delete']")).click();
		//driver.findElement(By.cssSelector("[name='Delete']")).click();
		// Thread.sleep(2000);
		
		wb.alertAccept(driver);
		
//        Alert alt = driver.switchTo().alert();
//        
//        alt.accept();
         
		pm.validateProduct(driver, name);
		
		//--------Written in ProductModulePage class of POM--------
//		 List<WebElement> prdList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
//		 Boolean flag = false;
//		 for(WebElement prd:prdList)
//		 {
//			 String actData = prd.getText();
//			 if(actData.contains(name))
//			 {
//				 flag=true;
//				 break;
//			 }
//		 }
//		if(flag)
//		{
//			System.out.println("Product is  deleted ");
//		}
//		else
//		{
//			System.out.println("Product is not deleted");
//		}
		
		//driver.findElement(By.xpath("//td[@class='small'][1]//td[@class='small']")).click();
		// driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		

//---------Written in AfterMethod of BaseClass TestNG--------------------
//hp.Logout(driver);
	}

}
