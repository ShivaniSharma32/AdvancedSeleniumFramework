package PomRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_Module_Page {

	//Initailization
	public Product_Module_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
  
	//Declaration 
	@FindBy(xpath="//td[@class='tabUnSelected']//a[text()='Products']")
	private WebElement clickProduct;
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createProduct;
	
	@FindBy(css="[name='productname']")
	private WebElement ProductName;
	
	@FindBy(css="[id='dtlview_Product Name']")
	private WebElement CheckProduct;
	
	//Getter Methods
	public WebElement getClickProduct() {
		return clickProduct;
	}

	public WebElement getCreateProduct() {
		return createProduct;
	}
	
	public WebElement getProductName() {
		return ProductName;
	}
	
	public WebElement getCheckProduct() {
		return CheckProduct;
	}
	
	//	Business Logic Methods
	public void clickOnProduct()
	{
		clickProduct.click();
	}
	public void clickOnCreateProduct()
	{
		createProduct.click();
	}
	public void clickOnProductName(String name)
	{
		ProductName.sendKeys(name);
	}
	public String clickOnCheckProduct()
	{
		String text=CheckProduct.getText();
		return text;
		
	}
	public void dynamicXpath(WebDriver driver, String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']/../preceding-sibling::td/input")).click();
	}
	public void validateProduct(WebDriver driver, String productData)
	{
	List<WebElement> prdList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
	 Boolean flag = false;
	 for(WebElement prd:prdList)
	 {
		 String actData = prd.getText();
		 if(actData.contains(productData))
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