package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
 
	@FindBy (xpath="//input[@id='first-name']")
	private WebElement firstName ;
	
	@FindBy (xpath="//input[@id='last-name']")
	private WebElement lastName ;
	
	@FindBy (xpath="//input[@id='postal-code']")
	private WebElement postalCode ;
	
	@FindBy (xpath="//input[@type='submit']")
	private WebElement submit;
	
	public CheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void enterFirstName()
	{
		firstName.sendKeys("Chota");
	}
	public void enterLastName()
	{
		lastName.sendKeys("Don");
	}
	public void enterPostalCode()
	{
		postalCode.sendKeys("420420");
	}
	public void clickOnContinue()
	{
		submit.click();
	}
}
