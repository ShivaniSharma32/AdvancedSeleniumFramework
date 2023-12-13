package PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	
	//Initalize
	public Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration-----Encapsulation concept used
	@FindBy(name="user_name")
	private WebElement UserTextField;
	
	@FindBy(name="user_password")
	private WebElement PasswordTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	
	//Getter Method
//	public WebElement getUserTextField() {
//		return UserTextField;
//	}
//
//	public WebElement getPasswordTextField() {
//		return PasswordTextField;
//	}
//
//	public WebElement getLoginButton() {
//		return loginButton;
//	}

	//Instead of Getter method always perfer Business logics
	//Business logics
	public void loginToApplication(String Username, String Password)
	{
		UserTextField.sendKeys(Username);
		PasswordTextField.sendKeys(Password);
		loginButton.click();
	}
	
	
	
    
}
