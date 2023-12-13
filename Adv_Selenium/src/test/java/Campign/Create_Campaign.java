package Campign;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utiltity;
import PomRepository.Campign_Module_Page;
import PomRepository.Home_Page;
import PomRepository.Login_Page;



//@Listeners(Generic_Utilities.ListenersImplementation.class)
@Listeners(Generic_Utilities.ExtentImplementation.class)
public class Create_Campaign extends BaseClass {

//@Test(groups="SmokeTest")
	
	@Test(retryAnalyzer= Generic_Utilities.RetryImplementation.class)
	//@Test
	
	public void Create_CampaignTest() throws Throwable{
	
	//public static void main(String[] args) throws Throwable {
		
		
	//------Access by using file Utility---------
//		WebDriver driver = new ChromeDriver();
		
//		-------Written in before class of TestNG --- no need to write in script--------	
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
		
		
		
		
		
		
	//	-------Written in before class of TestNG --- no need to write in script-----
//		WebDriver_Utiltity wb= new WebDriver_Utiltity();
//		wb.maximizingWindow(driver);
//		wb.minimizingWindow(driver);
//     	wb.ImplicitWait(driver);
//		
		
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//------Written in TestNG BeforeMethod of Base class
//		File_Utility flib= new File_Utility();
//		String URL = flib.getKeyAndValue("url");
//		String USERNAME =flib.getKeyAndValue("username");
//		String PASSWORD = flib.getKeyAndValue("password");
//		
//		driver.get(URL);
//		
		
		//--------Written in POM Classes---------
//		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(USERNAME);
//		driver.findElement(By.cssSelector("[name='user_password']")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		
		
		//-- Written in TestNG Before Method as well
		//----Access by using Business Logics--- 
//		 Login_Page lg= new Login_Page(driver);
//		 lg.loginToApplication(USERNAME, PASSWORD);
		
		
		
		/*driver.get("http://localhost:8888/");
		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys("admin");
		driver.findElement(By.cssSelector("[name='user_password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();*/
		
		//WebElement element = driver.findElement(By.xpath("//a[text()='More']"));
		 
		 //Using Object creation of POM classes
		 Home_Page hp= new  Home_Page(driver);
		 
		 Campign_Module_Page cm= new Campign_Module_Page(driver);
		 
		 hp.clickOnMoreLink();
		//wb.ActionClass(driver,element);
		//Actions ac= new Actions(driver);
		//ac.moveToElement(element).click().perform();
		
		//driver.findElement(By.cssSelector("[name='Campaigns']")).click();
		 hp.clickOnCampignLink();
		//driver.findElement(By.cssSelector("[title='Create Campaign...']")).click();
		 cm.clickOnCampignTitleLink();
		
		//driver.findElement(By.cssSelector("[title='Select']")).click();

		
		
		
		 Java_Utility ju= new Java_Utility();
		 int rannum = ju.getRandomNum();
		
		
		/*Random rc= new Random();
		int rannum = rc.nextInt(1000);*/
		
		 
		 
		 Excel_Utility elib = new Excel_Utility();
		 String caName = elib.getExcelData("Campaigns", 0, 0)+rannum;
		 
		 
		 
		//String caName="YETER"+rannum;
		
		 
		 cm.clickOnCampignName(caName);
		 
		//driver.findElement(By.cssSelector("[name='campaignname']")).sendKeys(caName);
		 Thread.sleep(2000);
		 hp.clickOnSave();
		 
		 Assert.assertEquals(false, true);// intentionally write to check whether listerners take ss or not 
		
		 
		 cm.clickOnCheckCampaigns();
		// cm.getCheckCampaigns();
		 
        // cm.setCheckCampaignsValidation(caName);
		 Thread.sleep(3000);
		 
	// Using Hard Assertion instead of IF-Else Statement 
		 try {
		 Assert.assertEquals(cm.clickOnCheckCampaigns(), caName);
		Reporter.log("Campaignname Created Successfully",true);
		
		 }catch(AssertionError  e)
		 {
			 Reporter.log("Campaignname not Created Successfully",true);
		 }
		 
		 
		 
	 
//		if(cm.clickOnCheckCampaigns().equals(caName))
//		{
//			System.out.println("Campaignname Created Successfully");
//		}
//		else
//		{
//			System.out.println("Campaignname Not created");
//		}
		
		
		//driver.findElement(By.xpath("//td[@class='small'][1]//td[@class='small']")).click();
				// driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				

//---------Written in AfterMethod of BaseClass TestNG--------------------
		//hp.Logout(driver);
		
		
		 		
	}




	}


