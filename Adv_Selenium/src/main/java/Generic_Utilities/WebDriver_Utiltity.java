package Generic_Utilities;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriver_Utiltity {

		public void minimizingWindow(WebDriver driver)
		{
			driver.manage().window().minimize();
		}
		public void ImplicitWait(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		public void maximizingWindow(WebDriver driver)
		{
			driver.manage().window().maximize();
		}
		public void ActionClass(WebDriver driver, WebElement element)
		{
			Actions ac= new Actions(driver);
			ac.moveToElement(element).click().perform();
		}
		
		public void WindowSwitching(WebDriver driver, String PartialVisibleText)
		{
			Set<String> allWindowIDs = driver.getWindowHandles();
			Iterator<String> window = allWindowIDs.iterator();
			while(window.hasNext())
			{
				String win = window.next();
				driver.switchTo().window(win);
				String title = driver.getTitle();
				if(title.contains(PartialVisibleText))
				{
					break;
				}
			}
		}
		public void alertAccept(WebDriver driver)
		{
			Alert alt = driver.switchTo().alert();
			alt.accept();
		}
		
		
		public static String takescreenShot(WebDriver driver, String screenShotName)throws Throwable{
			TakesScreenshot takeScreenShot =(TakesScreenshot)driver;
			File src= takeScreenShot.getScreenshotAs(OutputType.FILE);
			File dst= new File("./ScreenShots/"+screenShotName+".png");
			FileUtils.copyFile(src, dst);
			return dst.getAbsolutePath();
			
		}
		
		
	}


