package PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization_Module_Page {
	
	//Initailization
	public Organization_Module_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	//Declaration of Product Module
		
	@FindBy(xpath="//td[@class='tabUnSelected']//a[text()='Organizations']")
	private WebElement clickOrganizations;
		
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrganization;
		
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement enterAccountName;
	
	@FindBy(css="[id='phone']")
	private WebElement enterPhone;
	
	@FindBy(xpath="//span[@id='dtlview_Organization Name']")
	private WebElement getOrganizationName;
	
	//Business Logic Method
	public void clickOnOrganizations()
	{
		clickOrganizations.click();
	}
	public void createOnOrganization()
	{
		createOrganization.click();
	}
	public void enterOnAccountName(String Orgname)
	{
		enterAccountName.sendKeys(Orgname);;
	}
	public void enterOnPhone(String phone_num)
	{
		enterPhone.sendKeys(phone_num);
	}
	public String OrganizationName()
	{
		String Organization_name=getOrganizationName.getText();
		return Organization_name;
	}
	}


