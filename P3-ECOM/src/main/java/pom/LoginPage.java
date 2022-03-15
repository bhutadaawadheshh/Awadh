package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
   
	@FindBy (xpath="//input[@id='user-name']")
	private WebElement username ;
	
	@FindBy (xpath="//input[@id='password']")
	private WebElement password ;
	
	@FindBy (xpath="//input[@type='submit']")
	private WebElement loginbutton ;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

	public void enterUsername()
	{
		username.sendKeys("standard_user");
	}
	public void enterPassword()
	{
		password.sendKeys("secret_sauce");
	}
	public void clickOnLoginButton()
	{
		loginbutton.click();
	}
}
