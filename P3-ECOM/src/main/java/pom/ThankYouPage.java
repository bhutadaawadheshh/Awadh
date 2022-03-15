package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThankYouPage {

	@FindBy (xpath="//button[@id='back-to-products']")
	private WebElement complete;
	
	public ThankYouPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOnHome()
	{
		complete.click();
	}

}
