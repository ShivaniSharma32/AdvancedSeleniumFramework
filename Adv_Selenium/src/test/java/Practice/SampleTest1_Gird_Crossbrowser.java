package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DriverCommand;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.BaseClassForGrid;

public class SampleTest1_Gird_Crossbrowser extends BaseClassForGrid {

	@Test
	public void m1Test(){
		driver.get("https://www.flipkart.com/");
		
	}

}
