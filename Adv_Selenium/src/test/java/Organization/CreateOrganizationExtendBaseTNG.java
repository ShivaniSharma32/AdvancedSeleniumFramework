package Organization;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Utilities.BaseclassForTestNG;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import PomRepository.Home_Page;
import PomRepository.Organization_Module_Page;

public class CreateOrganizationExtendBaseTNG  extends BaseclassForTestNG{
	//@Test(groups="RegressionTest")
	@Test
	public void Create_OrganizationTest() throws InterruptedException, Throwable
	{
		

	//public static void main(String[] args) throws InterruptedException, Throwable {
	//WebDriver driver = new ChromeDriver();
		
		
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
//	WebDriver_Utiltity wb= new WebDriver_Utiltity();
//	wb.maximizingWindow(driver);
//	wb.minimizingWindow(driver);
//	wb.ImplicitWait(driver);
//	
	
	
	
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	/*FileInputStream fis = new FileInputStream("./src/test/resources/AdvSeleniumCommonData.properties");
	
	Properties p = new Properties();
	p.load(fis);*/
	
	
//	-------Written in before class of TestNG --- no need to write in script--------		
//	File_Utility flib= new File_Utility();
//	String URL = flib.getKeyAndValue("url");
//	String USERNAME =flib.getKeyAndValue("username");
//	String PASSWORD = flib.getKeyAndValue("password");
	//driver.get(URL);
	
	
	//--------Written in POM Classes--------
//	driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(USERNAME);
//	driver.findElement(By.cssSelector("[name='user_password']")).sendKeys(PASSWORD);
//	driver.findElement(By.id("submitButton")).click();
	
	
	//Object Creatin of POM class (it is applicable for login page webelement not url)
	
	//Login_Page lg= new Login_Page(driver);
//	lg.getUserTextField().sendKeys(USERNAME);
//	lg.getPasswordTextField().sendKeys(PASSWORD);
//	lg.getLoginButton().click();
//	
	
	//Access by using Business Logics 
	//-- Written in TestNG Before Method as well
	// lg.loginToApplication(USERNAME, PASSWORD);
	
	 //Using Object creation of POM classes
	 Home_Page hp= new  Home_Page(driver);
	 Organization_Module_Page om= new Organization_Module_Page(driver);
	 
	om.clickOnOrganizations();
	// driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();
	 
	om.createOnOrganization();
	 //driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	Assert.assertEquals(false, true);
	 
	 /* Random r = new Random();
	  int rc = r.nextInt(1000);*/
	 
	 Java_Utility ju= new Java_Utility();
	 int rc = ju.getRandomNum();
	 
	 
	 
	 
	// String name= "Qspider3"+rc;
	 
	 Excel_Utility elib = new Excel_Utility();
	 String Orgname = elib.getExcelData("Organization", 0, 0)+rc;
	 
	 
	 
	 
	 
	 
	 /*FileInputStream fes = new FileInputStream("./src/test/resources/TestData.xlsx");
	  Workbook book = WorkbookFactory.create(fes);
	  Sheet sheet = book.getSheet("Organization");
	 Row ro = sheet.getRow(0);
	 Cell cel = ro.getCell(0);
	String Orgname = cel.getStringCellValue()+rc;*/
	 
	 
	 
	 
	 om.enterOnAccountName(Orgname);
	//  driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(Orgname);
	 
	  String phone_num = elib.getExcelDataUsingDataFormatter("Organization", 1, 0);
		 
	  
	 /* Row ro1 = sheet.getRow(0);
		 Cell cel1 = ro1.getCell(1);*/
		/* DataFormatter format = new DataFormatter();
		 
	String phone_num = format.formatCellValue(cel1);*/
		 
	    om.enterOnPhone(phone_num);
		//driver.findElement(By.cssSelector("[id='phone']")).sendKeys(phone_num);
	
		hp.clickOnSave();
	// driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		 Thread.sleep(3000);
		
		om.OrganizationName();
	// String Organization_name = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
	 
	 Thread.sleep(3000);
	 
	// Using Hard Assertion instead of IF-Else Statement 
			 try {
			 SoftAssert s= new SoftAssert();
			 s.assertEquals(om.OrganizationName(), Orgname);
			 Reporter.log("Organization is Created in Organization page Succefully",true);
			 s.assertAll();
			 }catch(AssertionError  e)
			 {
				 Reporter.log("Not created",true);
			 }

	 
	
//	 if(om.OrganizationName().equals(Orgname))
//	 {
//		 System.out.println("Organization is Created in Organization page Succefully");
//	 }
//	 else
//	 {
//		 System.out.println("Not created");
//	 }
//	 
	//driver.findElement(By.xpath("//td[@class='small'][1]//td[@class='small']")).click();
		// driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		

//---------Written in AfterMethod of BaseClass TestNG--------------------
//hp.Logout(driver);
	 	

	}

}


