package Generic_Utilities;



import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementation implements ITestListener{

	
	public void onTestFailure(ITestResult result) {
		
	String testData = result.getMethod().getMethodName();
	

EventFiringWebDriver edriver= new EventFiringWebDriver(BaseClass.sdriver);// when u extends baseclass 

	//EventFiringWebDriver edriver= new EventFiringWebDriver(BaseclassForTestNG.sdriver);// when u extends baseclassfortestNG

File src = edriver.getScreenshotAs(OutputType.FILE);

try {
	
	FileUtils.copyFile(src, new File("./ScreenShot/"+testData+".png"));
	
}catch (Exception e)
{
	e.printStackTrace();
}



	
	
	
	
	
	
	}
	


}
