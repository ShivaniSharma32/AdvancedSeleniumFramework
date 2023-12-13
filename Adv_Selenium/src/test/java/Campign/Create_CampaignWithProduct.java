package Campign;

import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utiltity;
import PomRepository.Campign_Module_Page;
import PomRepository.Home_Page;
import PomRepository.Login_Page;
import PomRepository.Product_Module_Page;



public class Create_CampaignWithProduct extends BaseClass{

	@Test(groups={"SmokeTest","RegressionTest"})
	public void CCreate_CampaignWithProductTest() throws Throwable{

	//public static void main(String[] args) throws Throwable {

		
		//------Access by using file Utility---------
//			WebDriver driver = new ChromeDriver();
			
//			-------Written in before class of TestNG --- no need to write in script--------	
			/*File_Utility flib= new File_Utility();
			WebDriver driver;
			String BROWSER= flib.getKeyAndValue("browser");
			if(BROWSER.equalsIgnoreCase("CHORME"))
			{
				driver = new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("Edge"))
			{
				driver = new EdgeDriver();
			}
			else
			{
				driver = new ChromeDriver();
			}*/
		
//		-------Written in before class of TestNG --- no need to write in script--------
		WebDriver_Utiltity wb= new WebDriver_Utiltity();
//		wb.maximizingWindow(driver);
//		wb.minimizingWindow(driver);
//		wb.ImplicitWait(driver);
		
		Home_Page hp= new  Home_Page(driver);
		Campign_Module_Page cm= new Campign_Module_Page(driver);
		Product_Module_Page pm= new Product_Module_Page(driver);
		 
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
//		-------Written in before class of TestNG --- no need to write in script--------		
//		File_Utility flib= new File_Utility();
//		String URL = flib.getKeyAndValue("url");
//		String USERNAME =flib.getKeyAndValue("username");
//		String PASSWORD = flib.getKeyAndValue("password");
		//driver.get(URL);
		
		//--------Written in POM Classes--------
//		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(USERNAME);
//		driver.findElement(By.cssSelector("[name='user_password']")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		//Access by using Business Logics 
		//-- Written in TestNG Before Method as well
//		 Login_Page lg= new Login_Page(driver);
//		 lg.loginToApplication(USERNAME, PASSWORD);
		
//		driver.get("http://localhost:8888/");
//		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys("admin");
//		driver.findElement(By.cssSelector("[name='user_password']")).sendKeys("admin");
//		driver.findElement(By.id("submitButton")).click();
		
		 pm.clickOnProduct();
		//driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Products']")).click();
		
		 pm.clickOnCreateProduct();
		//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		Java_Utility ju= new Java_Utility();
		 int ranum = ju.getRandomNum();
		
//		Random ran = new Random();
//		int ranum = ran.nextInt(1000);
		
		 Excel_Utility elib = new Excel_Utility();
		 String name = elib.getExcelData("Product", 0, 0)+ranum;
		 
		//String name="Apple" +ranum;
		 
		 pm.clickOnProductName(name);
		// driver.findElement(By.cssSelector("[name='productname']")).sendKeys(name);
	
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
		
		 hp.clickOnMoreLink();
	//	WebElement element = driver.findElement(By.xpath("//a[text()='More']"));
		
		//wb.ActionClass(driver,element);
//		Actions ac= new Actions(driver);
//		ac.moveToElement(element).click().perform();
		
		 hp.clickOnCampignLink();
		//driver.findElement(By.cssSelector("[name='Campaigns']")).click();
		 cm.clickOnCampignTitleLink();
		//driver.findElement(By.cssSelector("[title='Create Campaign...']")).click();
		 
		 cm.clickOnSelectProduct();
		//driver.findElement(By.cssSelector("[title='Select']")).click();
		String main = driver.getWindowHandle();
		
		
		wb.WindowSwitching(driver, "Products&action");
		
//		Set<String> allWindowIDs = driver.getWindowHandles();
	      /*for(String ID:allWindowIDs)
	       {
	    
	    	  driver.switchTo().window(ID);
	    	   String title = driver.getTitle();
	    	  if (title.contains("Products&action"))
	    			   {
	    		  break;
	    			   }
	       }*/
		
		//OR
		
//		Set<String> allWindowIDs = driver.getWindowHandles();
//		Iterator<String> window = allWindowIDs.iterator();
//		while(window.hasNext())
//		{
//			String win = window.next();
//			driver.switchTo().window(win);
//			String title = driver.getTitle();
//			if(title.contains("Products&action"))
//			{
//				break;
//			}
//		}
//		
	         cm.clickOnSearchProduct(name);
	      // driver.findElement(By.cssSelector("[name='search_text']")).sendKeys(name);
	        cm.clickOnSearchButton();
   		  // driver.findElement(By.cssSelector("[name='search']")).click();
   		   
   		   //driver.findElement(By.cssSelector("[id='5']")).click();//OR
   		   //OR
	        
	       driver.findElement(By.xpath("//a[text()='"+name+"']")).click();
	       
	    	driver.switchTo().window(main);
	    	
		
	    
			 String caName = elib.getExcelData("Campaigns", 0, 0)+ranum;

		
		
		//String caName="YETER"+ranum;
			 cm.clickOnCampignName(caName);
			// cm.setcampaignName(caName);
		//driver.findElement(By.cssSelector("[name='campaignname']")).sendKeys(caName);
			 Thread.sleep(2000);
		hp.clickOnSave();
		// driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		
		cm.clickOnCheckCampaigns();
		//cm.getCheckCampaigns();
		// String Campaignname = driver.findElement(By.cssSelector("[id='dtlview_Campaign Name']")).getText();
		 Thread.sleep(3000);
		if(cm.clickOnCheckCampaigns().equals(caName))
		{
			System.out.println("Campaignname Created Successfully");
		}
		else
		{
			System.out.println("Campaignname Not created");
		}
		
		//driver.findElement(By.xpath("//td[@class='small'][1]//td[@class='small']")).click();
		// driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		

//---------Written in AfterMethod of BaseClass TestNG--------------------
//hp.Logout(driver);

	}
}
