package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

;

public class Dynamic_xpath2 {

	public static void main(String[] args) throws InterruptedException {

	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://demowebshop.tricentis.com/");
	
	driver.findElement(By.xpath("//ul[@class='top-menu']/li[5]")).click();
	List<WebElement> element = driver.findElements(By.xpath("//input[@value='Add to cart']"));
	for(WebElement wb:element)
	{
		wb.click();
		Thread.sleep(2000);
	}
	driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
	
	List<WebElement> element1 = driver.findElements(By.xpath("//input[@name='removefromcart']"));
	for(WebElement wb1:element1)
	{
		wb1.click();
	}
	driver.findElement(By.xpath("//input[@value='Update shopping cart']")).click();
	}

}
