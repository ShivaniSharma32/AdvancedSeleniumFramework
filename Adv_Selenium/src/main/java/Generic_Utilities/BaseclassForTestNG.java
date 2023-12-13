package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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



// All the classes extend this base class .if you want executing All TestNG (batch,parallel, group, crossbrowser execution 

public class BaseclassForTestNG {
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite(groups={"SmokeTest","RegressionTest","SanityTest"})
	
	public void beforeSuite()
	{
		System.out.println("Database Connection");
	}
	
	@BeforeTest(groups={"SmokeTest","RegressionTest","SanityTest"})
	 public void beforeTest()
	 {
		System.out.println("Parallel Execution Start");
	 }
	@Parameters("BROWSER")
	@BeforeClass(groups={"SmokeTest","RegressionTest","SanityTest"})
//	public void beforeClass() throws Throwable
//	{
		//WebDriver driver;
//		File_Utility flib= new File_Utility();
//		String BROWSER= flib.getKeyAndValue("browser");
	
	public void beforeClass(String BROWSER)
	
	{
	    if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
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
	}
	
	@Parameters({"URL","USERNAME","PASSWORD"})
	@BeforeMethod(groups={"SmokeTest","RegressionTest","SanityTest"})
//	public void beforeMethod() throws Throwable
//	{
//		File_Utility flib= new File_Utility();
//		String URL = flib.getKeyAndValue("url");
//		String USERNAME =flib.getKeyAndValue("username");
//		String PASSWORD = flib.getKeyAndValue("password");
	
	public void beforeMethod(String URL, String USERNAME, String PASSWORD)
	{
		driver.get(URL);
		Login_Page lg= new Login_Page(driver);
	 lg.loginToApplication(USERNAME, PASSWORD);
		
		System.out.println("Login to Application");
	}
	
	@AfterMethod(groups={"SmokeTest","RegressionTest","SanityTest"})
	public void afterMethod()
	{
		 Home_Page hp= new  Home_Page(driver);
		hp.Logout(driver);
		System.out.println("Logout Application");
	}
	
	@AfterClass(groups={"SmokeTest","RegressionTest","SanityTest"})
	public void afterClass()
	{
		driver.quit();
		System.out.println("Close Browser");
	}
	
	@AfterTest(groups={"SmokeTest","RegressionTest","SanityTest"})
	public void afterTest()
	{
		System.out.println("Parallel Execution done");
	}
	
	@AfterSuite(groups={"SmokeTest","RegressionTest","SanityTest"})
	public void afterSuite()
	{
		System.out.println("Database Connection close");
	}
}


