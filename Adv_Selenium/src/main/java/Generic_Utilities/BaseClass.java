package Generic_Utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import PomRepository.Home_Page;
import PomRepository.Login_Page;

public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite
	
	public void beforeSuite()
	{
		System.out.println("Database Connection");
	}
	
	@BeforeTest
	 public void beforeTest()
	 {
		System.out.println("Parallel Execution Start");
	 }

	@BeforeClass
	public void beforeClass() throws Throwable
	{
		
		File_Utility flib= new File_Utility();
		String BROWSER= flib.getKeyAndValue("browser");
	
	
	    if(BROWSER.equalsIgnoreCase("CHORME"))
		{
			driver = new ChromeDriver();
		
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new EdgeDriver();
			
		}
		else
		{
			driver = new ChromeDriver();
			
		}
	    sdriver= driver;
		WebDriver_Utiltity wb= new WebDriver_Utiltity();
		wb.maximizingWindow(driver);
		wb.minimizingWindow(driver);
		wb.ImplicitWait(driver);
		
		System.out.println("Launch Browser");
		sdriver=driver;
	}
	
	@BeforeMethod
	public void beforeMethod() throws Throwable
	{
		File_Utility flib= new File_Utility();
		String URL = flib.getKeyAndValue("url");
		String USERNAME =flib.getKeyAndValue("username");
		String PASSWORD = flib.getKeyAndValue("password");
	
	
	
		driver.get(URL);
		Login_Page lg= new Login_Page(driver);
	 lg.loginToApplication(USERNAME, PASSWORD);
		
		System.out.println("Login to Application");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		 Home_Page hp= new  Home_Page(driver);
		hp.Logout(driver);
		System.out.println("Logout Application");
	}
	
	@AfterClass
	public void afterClass()
	{
		driver.quit();
		System.out.println("Close Browser");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("Parallel Execution done");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("Database Connection close");
	}
}
