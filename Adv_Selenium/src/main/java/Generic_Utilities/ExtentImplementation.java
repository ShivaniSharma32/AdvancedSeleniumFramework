package Generic_Utilities;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentImplementation implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
	test=report.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
	test.log(Status.PASS, result.getMethod().getMethodName());
	test.log(Status.PASS, result.getThrowable());
	}

	public void onTestFailure(ITestResult result) {
//		String testData = result.getMethod().getMethodName();
//		
//		//EventFiringWebDriver edriver= new EventFiringWebDriver(BaseClass.sdriver);// when u extends baseclass 
//
//	EventFiringWebDriver edriver= new EventFiringWebDriver(BaseclassForTestNG.sdriver);// when u extends baseclassfortestNG
//
//		File src = edriver.getScreenshotAs(OutputType.FILE);
//
//		try {
//			
//			FileUtils.copyFile(src, new File("./ScreenShot/"+testData+".png"));
//			
//		}catch (Exception e)
//		{
//			e.printStackTrace();
//		}
		
		
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
		System.out.println("..........I am listening....");
		String screenShot = null;
		try
		{
			screenShot= WebDriver_Utiltity.takescreenShot(BaseClass.sdriver, result.getMethod().getMethodName());
		} catch (Throwable e)
		{
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenShot);
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onStart(ITestContext context) {
		Java_Utility jlib= new Java_Utility();
		int ranrum= jlib.getRandomNum();
		
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/Report.html"+ranrum);// set the outlook
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Testing");
		spark.config().setReportName("Shivani");
		
		//System Configuration
		report= new ExtentReports();
		
		report.attachReporter(spark);
		report.setSystemInfo("plateform", "windows10");
		report.setSystemInfo("executed by", "shivi");
		report.setSystemInfo("reviewed by", "Payal");
		
		
	}

	public void onFinish(ITestContext context) {
		report.flush();
		
	}
	
	

}
