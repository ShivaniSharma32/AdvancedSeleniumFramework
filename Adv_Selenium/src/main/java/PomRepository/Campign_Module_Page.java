package PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campign_Module_Page {

	//Initailization
	public Campign_Module_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Declaration 
	@FindBy(css="[title='Create Campaign...']")
	private WebElement campaignsTitleLink;
	
	@FindBy(css="[name='campaignname']")
	private WebElement campaignName;
	
	@FindBy(css="[id='dtlview_Campaign Name']")
	private WebElement CheckCampaigns;
	
	@FindBy(css="[title='Select']")
	private WebElement selectProduct;
	
	@FindBy(css="[name='search_text']")
	private WebElement searchProduct;
	
	@FindBy(css="[name='search']")
	private WebElement searchButton;
	
	
	//Getter Methods
	public WebElement getCampaignsTitleLink() {
		return campaignsTitleLink;
	}
	public WebElement getCampaignName() {// No need , can access by using set method 
		return campaignName;
	}
	
//	
	public WebElement getCheckCampaigns() {
		return CheckCampaigns;
	}
//	public String getCheckCampaigns() {
//		String Campaign_name=CheckCampaigns.getText();
//		return Campaign_name;
//		
//	}
	
	public WebElement getSelectProduct() {
		return selectProduct;
	}
	public WebElement getSearchProduct() {
		return searchProduct;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	

	//	Business Logic Methods
	public void clickOnCampignTitleLink()
	{
		campaignsTitleLink.click();
	}
	
	public void clickOnCampignName(String caName)// by business logic 
	{
		campaignName.sendKeys(caName);
	}
//	String caName;
//	public void setcampaignName(String caName)
//	{
//		this.caName= caName;
//		campaignName.sendKeys(caName);
//	}
	
	
	
//	public void setCheckCampaignsValidation(String caName)
//	{
//		this.caName= caName;
//		if(getCheckCampaigns().equals(caName))
//		{
//			System.out.println("Campaignname Created Successfully");
//		}
//		else
//		{
//			System.out.println("Campaignname Not created");
//		}
//	}
	
	
	public String clickOnCheckCampaigns()
	{
		String Campaignname=CheckCampaigns.getText();
		return Campaignname;
		
	}
	public void clickOnSelectProduct()
	{
		selectProduct.click();
	}
	public void clickOnSearchProduct(String name)
	{
		searchProduct.sendKeys(name);
	}
	public void clickOnSearchButton()
	{
		searchButton.click();
	}
	
	
	}
	
