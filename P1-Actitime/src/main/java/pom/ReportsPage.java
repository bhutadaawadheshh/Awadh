package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsPage {
	
	@FindBy (xpath="//span[@unselectable='on']")
	private WebElement createReport;
	
	@FindBy (xpath="//div[@class='report-type  TIME']")
	private WebElement overTime;
	
	@FindBy (xpath="(//input[@type='button'])[3]")
	private WebElement configureReport;
	
	@FindBy (xpath="//input[@name='saveConfigStatus']")
	private WebElement checkBox;
	
	@FindBy (xpath="//div[text()='Last 14 days']")
	private WebElement timeRange;
	
	private Actions act;                                            //mouse action
	public ReportsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	    act = new Actions(driver);
	}
	
	public void clickOnCreateReport() 
	{
		act.moveToElement(createReport).click().build().perform();		
	}
	
	public void clickOnOverTime() 
	{
		overTime.click();		
	}
	
	public void configureReportParameters() 
	{
		configureReport.click();		
	}
	
	public void selectTimeRange() 
	{
		timeRange.click();		
	}
	
	public void clickOnCheckBox() 
	{
		checkBox.click();		
	}
	
	

	

}
