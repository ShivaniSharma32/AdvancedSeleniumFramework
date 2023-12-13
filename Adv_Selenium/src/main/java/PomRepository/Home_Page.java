package PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utiltity;

public class Home_Page {
	
//Initailization
	public Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//Declaration 
	
	@FindBy(xpath="(//a[text()='Products'])[1]")
	private WebElement Product;
	
	@FindBy(xpath="//input[@accesskey='S']")
	private WebElement save;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement Delete;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreLink;
	
	@FindBy(css="[name='Campaigns']")
	private WebElement campaignsLink;
	
	@FindBy(xpath="//td[@class='small'][1]//td[@class='small']")
	private WebElement AdministratorSign;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutLink;
	
	//Getter Methods 
	public WebElement getMoreLink() {
		return moreLink;
	}
	public WebElement getCampaignsLink() {
		return campaignsLink;
	}
	public WebElement getSave() {
		return save;
	}
    public WebElement getProduct() {
		return Product;
	}
	public WebElement getDelete() {
		return Delete;
	}

	public WebElement getAdministratorSign() {
		return AdministratorSign;
	}
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	//Business Logic Methods
	public void clickOnSave()
	{
		save.click();
	}
	public void clickProduct()
	{
		Product.click();
	}
	public void clickOnDelete()
	{
		Delete.click();
		
	}
	public void clickOnMoreLink()
	{
		moreLink.click();
	}
	public void clickOnCampignLink()
	{
		campaignsLink.click();
	}	
	
	public void Logout(WebDriver driver)
	{
		WebDriver_Utiltity wb= new WebDriver_Utiltity();
		wb.ActionClass(driver, AdministratorSign);
		signOutLink.click();
	}
}

