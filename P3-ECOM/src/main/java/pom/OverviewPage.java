package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {
  
	
	@FindBy (xpath="//button[@id='finish']")
	private WebElement finish;
	
	public OverviewPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOnFinish()
	{
		finish.click();
	}
}
