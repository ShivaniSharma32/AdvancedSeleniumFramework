package Generic_Utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseClassForGrid {

	

		public RemoteWebDriver driver;
		@Parameters("BROWSER")
		@BeforeClass
		public void config(String BROWSER) throws MalformedURLException
		{
			URL url = new URL("http://192.168.150.53:4444/wd/hub");
			DesiredCapabilities cap = new DesiredCapabilities();
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.WINDOWS);
			}
			else if(BROWSER.equalsIgnoreCase("firefox"))
			{
				cap.setBrowserName("firefox");
				cap.setPlatform(Platform.WINDOWS);
				
			}
			driver= new RemoteWebDriver(url,cap);
			WebDriver_Utiltity wb= new WebDriver_Utiltity();
			wb.maximizingWindow(driver);
			wb.minimizingWindow(driver);
			wb.ImplicitWait(driver);
			
			System.out.println("Launch Browser");
			
			
			
		}
	}


