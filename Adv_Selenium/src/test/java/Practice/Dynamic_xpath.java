package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dynamic_xpath {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demowebshop.tricentis.com/");
		
		driver.findElement(By.partialLinkText("Jewelry")).click();
		
		WebElement dropdown = driver.findElement(By.id("products-orderby"));
		
		Select s=new Select(dropdown);
		
		for(int i=0; i<6; i++)
		{
			s.selectByIndex(i);
			dropdown = driver.findElement(By.id("products-orderby"));//re-locate the webelement to avoid the staleElementException...b'coz webelement is getting old after selecting the next dropdown
			 s=new Select(dropdown);
			
			
			String name = driver.findElement(By.xpath("//div[@class='product-grid']/div[1]/div/div[2]//a")).getText();
			System.out.println(name);
			
			 
		}

	}

}
