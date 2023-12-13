package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utiltity;

public class CreateProductAndDelete {

	
		
		public static void main(String[] args) throws Throwable {
			WebDriver driver = new ChromeDriver();
			
			WebDriver_Utiltity wb= new WebDriver_Utiltity();
			wb.maximizingWindow(driver);
			wb.minimizingWindow(driver);
			wb.ImplicitWait(driver);
			
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			File_Utility flib= new File_Utility();
			String URL = flib.getKeyAndValue("url");
			String USERNAME =flib.getKeyAndValue("username");
			String PASSWORD = flib.getKeyAndValue("password");
			
			driver.get(URL);
			driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(USERNAME);
			driver.findElement(By.cssSelector("[name='user_password']")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			
//			driver.get("http://localhost:8888/");
//			driver.findElement(By.cssSelector("[name='user_name']")).sendKeys("admin");
//			driver.findElement(By.cssSelector("[name='user_password']")).sendKeys("admin");
//			driver.findElement(By.id("submitButton")).click();
//			
			driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Products']")).click();
			
			driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
			
			
			 Java_Utility ju= new Java_Utility();
			 int rannum = ju.getRandomNum();
			
//			Random rc= new Random();
//			int rannum = rc.nextInt(1000);
			 
			 Excel_Utility elib = new Excel_Utility();
			 String name = elib.getExcelData("Product", 0, 0)+rannum;
			
			//String name="Apple"+rannum;
			driver.findElement(By.cssSelector("[name='productname']")).sendKeys(name);
			
			driver.findElement(By.xpath("//input[@accesskey='S']")).click();
			
			String text = driver.findElement(By.cssSelector("[id='dtlview_Product Name']")).getText();
			if(text.equals(name))
			{
				System.out.println("Product is Created");
			}
			else
			{
				System.out.println("Product not Created");
			}
			
			
			driver.findElement(By.xpath("(//a[text()='Products'])[1]")).click();
			
			
			List<WebElement> elements = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]/a"));
			for(WebElement wb1 :elements)
			{
				 String Data=wb1.getText();
				if(Data.contains(name))
				{
					driver.findElement(By.xpath("//a[text()='"+name+"']/../preceding-sibling::td/input")).click();
				    Thread.sleep(2000);
				    
				}
			
			
		else
			{
				driver.findElement(By.xpath("//a[@title='Next']")).click();
				
				driver.findElement(By.xpath("//a[text()='"+name+"']/../preceding-sibling::td/input")).click();
				break;
				}
				
			}
			
			
		
			driver.findElement(By.xpath("//input[@value='Delete']")).click();
			//driver.findElement(By.cssSelector("[name='Delete']")).click();
			// Thread.sleep(2000);
			
			wb.alertAccept(driver);
			
//	        Alert alt = driver.switchTo().alert();
//	        
//	        alt.accept();
	         
			 List<WebElement> prdList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
			 Boolean flag = false;
			 for(WebElement prd:prdList)
			 {
				 String actData = prd.getText();
				 if(actData.contains(name))
				 {
					 flag=true;
					 break;
				 }
			 }
			if(flag)
			{
				System.out.println("Product is  deleted ");
			}
			else
			{
				System.out.println("Product is not deleted");
			}
			
			 	
		}

	

	}


